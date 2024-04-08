package edu.ithillel.multithreading.thread.states.examples;

/**
 * Thread.yield() - is hint to the scheduler that the current thread is willing to yield its current use of a processor.
 * The scheduler is free to ignore this hint.
 * Actually Thread.yield() return current Thread from "RUNNING" state to "RUNNABLE" state,
 * after that scheduler can choose again which Thread can be chosen to be "RUNNING", and
 * is can be either current thread or some another thread from pool.
 * After restoration of current Thread execution we will get to the line after Thread.yield().
 */
public class YieldExample implements CodeExample {
    @Override
    public void demonstrateExample() {
        System.out.println("#############################################");
        SimpleNamedThread t1 = new SimpleNamedThread("One", true);
        SimpleNamedThread t2 = new SimpleNamedThread("Two", false);
        SimpleNamedThread t3 = new SimpleNamedThread("Three",false);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("*********************************************");
    }

    class SimpleNamedThread extends Thread {
        public String name;
        public boolean isYielding;
        public SimpleNamedThread(String name, boolean isYielding) {
            super(name);
            this.name = name;
            this.isYielding = isYielding;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + name + " is started");
                if(isYielding){
                    System.out.println("Thread " + name + " is yielding");
                    Thread.yield();
                }
                Thread.sleep(500);
                System.out.println("Thread " + name + " is finished");
            } catch (InterruptedException e) {
                System.out.println("Thread " + name + " is interrupted");
            }
        }
    }
}
