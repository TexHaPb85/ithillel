package edu.ithillel.multithreading.concurency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        System.out.println("Processing other tasks...");

        futureResult.thenAccept(result -> System.out.println("Result: " + result));

        // Since CompletableFuture is non-blocking, no need to call get()

        System.out.println("we already here");
        // This is just to prevent the program from exiting immediately
        Thread.sleep(3000);
    }
}
