package edu.ithillel.multithreading.thread.synchronization.examples;

public class StaticSynchronizationExample implements CodeExample {
    static StringBuilder sb = new StringBuilder();
    @Override
    public void demonstrateProblem() {
        NumberFillerThread t1 = new NumberFillerThread(0,10);
        NumberFillerThread t2 = new NumberFillerThread(10,20);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.toString());
    }

    @Override
    public void demonstrateSynchronizationSolution() {
        SynchronizedNumberFillerThread t1 = new SynchronizedNumberFillerThread(0,10);
        SynchronizedNumberFillerThread t2 = new SynchronizedNumberFillerThread(10,20);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.toString());
    }

    class NumberFillerThread extends Thread {
        int from;
        int to;


        public NumberFillerThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++) {
                StaticSynchronizationExample.sb.append(i + ", ");
            }
        }
    }

    class SynchronizedNumberFillerThread extends Thread {
        int from;
        int to;

        public SynchronizedNumberFillerThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            synchronized (StaticSynchronizationExample.sb) {
                for (int i = from; i < to; i++) {
                    StaticSynchronizationExample.sb.append(i + ", ");
                }
            }
        }
    }
}
