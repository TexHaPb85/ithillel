package edu.ithillel.multithreading.thread.states.examples;

public class InterruptionExample implements CodeExample {
    @Override
    public void demonstrateExample() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("Thread started");
                        Thread.sleep(5000);
                        System.out.println("Thread finished");
                        if(Thread.interrupted()) {
                            return;
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.interrupt();//bool isInterrapted = true;
    }
}
