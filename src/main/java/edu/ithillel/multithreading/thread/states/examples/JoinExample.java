package edu.ithillel.multithreading.thread.states.examples;

/**
 * threadObj.join() call Thread.sleep()
 * until the object of thread for which we called .join() won`t finish its execution
 */
public class JoinExample implements CodeExample {
    @Override
    public void demonstrateExample() {
        SimpleNamedThread t1 = new SimpleNamedThread("One");
        SimpleNamedThread t2 = new SimpleNamedThread("Two");
        SimpleNamedThread t3 = new SimpleNamedThread("Three");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("thread " + t1.getName() + " was interrupted");
        }
        t3.start();

        System.out.println("Demo is finished");
    }

    class SimpleNamedThread extends Thread {
        public String name;

        public SimpleNamedThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + name + " is started");
                Thread.sleep(5000);
                System.out.println("Thread " + name + " is finished");
            } catch (InterruptedException e) {
                System.out.println("Thread " + name + " is interrupted");
            }
        }
    }
}
