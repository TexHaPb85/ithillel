package edu.ithillel.multithreading.thread.livelock;

/**
 * Livelock: Livelock is a special case of deadlock where threads are not blocked, but they are unable to make progress
 * because they are too busy responding to each other. In other words, livelock occurs when two or more threads keep
 * changing their state in response to the actions of the other threads, but no thread is able to complete its task.
 */
public class LivelockExample {
    private static volatile boolean condition1 = true;
    private static volatile boolean condition2 = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (condition1) {
                // Do some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition2 = true;
                System.out.println("Thread 1: Setting condition2 to true");
                while (condition2) {
                    // Set condition1 to false to make progress
                    condition1 = false;
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            while (condition2) {
                // Do some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition1 = true;
                System.out.println("Thread 2: Setting condition1 to true");
                while (condition1) {
                    // Set condition2 to false to make progress
                    condition2 = false;
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
