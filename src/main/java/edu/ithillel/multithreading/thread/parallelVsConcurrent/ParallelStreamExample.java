package edu.ithillel.multithreading.thread.parallelVsConcurrent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings({"", ""})
public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000).boxed().collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        long sum = numbers.stream()
            .reduce((i1, i2) -> i1+i2)
            .get();
        long endTime = System.currentTimeMillis();

        System.out.println("Sum using stream(): " + sum);
        System.out.println("Time taken with stream(): " + Math.abs(endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        sum = numbers.parallelStream()
            .reduce((i1, i2) -> i1+i2)
            .get();
        endTime = System.currentTimeMillis();

        System.out.println("Sum using parallelStream(): " + sum);
        System.out.println("Time taken with parallelStream(): " + Math.abs(endTime - startTime) + "ms");
    }
}
