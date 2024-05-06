package edu.ithillel.multithreading.concurency.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> futureResult = executor.submit(() -> {
            Thread.sleep(2000);
            return 42;
        });

        System.out.println("Processing other tasks...");

        Integer result = null; // Blocking call
        try {
            result = futureResult.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
