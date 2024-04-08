package edu.ithillel.multithreading.concurency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;

public class SumCountingExample {
    public static void main(String[] args) {
        simpleOneThreadCounting(Integer.MAX_VALUE/10);
        callableParallelCounting(Integer.MAX_VALUE/10,6);
    }

    public static void simpleOneThreadCounting(int valueToSum) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 1; i <= valueToSum; i++) {
            String s = String.valueOf(i);
            sum+=Integer.parseInt(s);
        }
        long finish = System.currentTimeMillis();
        System.out.println("simpleOneThreadCounting finished, result: " + sum);
        long resTime = (finish - start);
        System.out.println("time: " + resTime);
    }

    public static void callableParallelCounting(int valueToSum, int numOfCores) {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(numOfCores);
        List<Future<Long>> list = new ArrayList<Future<Long>>();
        int corePart = valueToSum / 6;
        for (int i = 0; i < numOfCores; i++) {
            int from = 1 + i * corePart;
            if(i==numOfCores-1) {
                list.add(executor.submit(new CallableCounter(from, valueToSum)));
            } else {
                int to = (i+1) * corePart;
                list.add(executor.submit(new CallableCounter(from, to)));
            }
        }
        long sum = list.stream().mapToLong(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            }
            return 0;
        }).sum();
        long finish = currentTimeMillis();
        System.out.println("callableParallelCounting finished, result: " + sum);
        long resTime = (finish - start);
        System.out.println("time: " + resTime);
        executor.shutdown();

    }
}
