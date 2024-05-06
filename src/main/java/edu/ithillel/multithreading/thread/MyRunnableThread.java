package edu.ithillel.multithreading.thread;

public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Running runnable thread " + Thread.currentThread());
        }
    }
}