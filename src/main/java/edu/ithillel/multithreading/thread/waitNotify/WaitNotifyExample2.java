package edu.ithillel.multithreading.thread.waitNotify;

public class WaitNotifyExample2 {
    private static final Object lock = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    // Wait until notified by another thread
                    while (!flag) {
                        System.out.println("Thread 1 is waiting");
                        lock.wait(); // Releases the lock and waits
                    }
                    // When notified, proceed with the task
                    System.out.println("Thread 1 is notified and completed its task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                // Perform some task
                System.out.println("Thread 2 is performing some task");
                // Notify other threads waiting on the lock
                flag = true;
                lock.notify(); // Notifies one waiting thread
            }
        });

        thread1.start(); // Start thread 1 first
        thread2.start(); // Start thread 2

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is done");
    }
}
