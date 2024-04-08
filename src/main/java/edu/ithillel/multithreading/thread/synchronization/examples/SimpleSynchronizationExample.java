package edu.ithillel.multithreading.thread.synchronization.examples;

public class SimpleSynchronizationExample implements CodeExample {
    @Override
    public void demonstrateProblem() {
        StringBuilder sb = new StringBuilder();
        NumberFillerThread t1 = new NumberFillerThread(0, 10, sb);
        NumberFillerThread t2 = new NumberFillerThread(10, 20, sb);

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
        StringBuilder sb = new StringBuilder();
        SynchronizedNumberFillerThread t1 = new SynchronizedNumberFillerThread(0, 10, sb);
        SynchronizedNumberFillerThread t2 = new SynchronizedNumberFillerThread(10, 20, sb);

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

    class SynchronizedNumberFillerThread extends Thread {
        int from;
        int to;
        StringBuilder sb;

        public SynchronizedNumberFillerThread(int from, int to, StringBuilder sb) {
            this.from = from;
            this.to = to;
            this.sb = sb;
        }

        @Override
        public void run() {
            synchronized (sb) {
                for (int i = from; i < to; i++) {
                    sb.append(i + ", ");
                }
            }

        }
    }

    class NumberFillerThread extends Thread {
        int from;
        int to;
        StringBuilder sb;

        public NumberFillerThread(int from, int to, StringBuilder sb) {
            this.from = from;
            this.to = to;
            this.sb = sb;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++) {
                sb.append(i + ", ");
            }
        }
    }
}
