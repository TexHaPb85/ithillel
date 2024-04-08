package edu.ithillel.multithreading.thread.states.examples;

public class InterruptionExample implements CodeExample {
    @Override
    public void demonstrateExample() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread started");
                    Thread.sleep(5000);
                    System.out.println("Thread finished");
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        });
        t1.start();
        t1.interrupt();
    }
}
