package edu.ithillel.multithreading.thread.deadlock;

import java.util.ArrayList;
import java.util.List;

public class DeadlockExample {
    private static final List<String> list1 = new ArrayList<>();
    private static final List<String> list2 = new ArrayList<>();

    public static void main(String[] args) {
        // Thread 1
        Thread thread1 = new Thread(() -> {
            synchronized (list1) {
                System.out.println("Thread 1 locked list1");
                try {
                    Thread.sleep(100); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list2) {
                    System.out.println("Thread 1 locked list2");
                }
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            synchronized (list2) {
                System.out.println("Thread 2 locked list2");
                try {
                    Thread.sleep(100); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (list1) {
                    System.out.println("Thread 2 locked list1");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads completed successfully");
    }
}