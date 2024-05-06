package edu.ithillel.multithreading.concurency.callableExecutorServiceExample;

import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Long> {
    public int from;
    public int toIncluding;

    public CallableCounter(int from, int toIncluding) {
        this.from = from;
        this.toIncluding = toIncluding;
    }

    public CallableCounter() {
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = from; i <= toIncluding; i++) {
            String s = String.valueOf(i);
            sum+=Integer.parseInt(s);
        }
        System.out.println("Thread " + Thread.currentThread() +
                " finished summirizing from " + from + " to " + toIncluding + " result: " + sum);
        return sum;
    }
}
