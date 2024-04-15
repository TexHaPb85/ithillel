package edu.ithillel.multithreading.concurency.locks;

public class RaceConditionExample {
    public static void main(String[] args) {
        //reentrantCounterExample();
        readWriteCounterExample();
    }

    private static void reentrantCounterExample() {
        ReentrantCounter reentrantCounter = new ReentrantCounter();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                System.out.println(reentrantCounter.incrementCounter());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                System.out.println(reentrantCounter.incrementCounter());
            }
        }).start();

        System.out.println(reentrantCounter.getCounter());
    }

    private static void readWriteCounterExample() {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                readWriteCounter.incrementCounter();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                readWriteCounter.incrementCounter();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                System.out.println(readWriteCounter.getCounter());
            }
        }).start();

        System.out.println(readWriteCounter.getCounter());
    }
}
