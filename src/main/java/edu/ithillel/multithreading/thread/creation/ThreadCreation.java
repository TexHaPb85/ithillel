package edu.ithillel.multithreading.thread.creation;

public class ThreadCreation {
    static class MyRunnableThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Running runnable thread " + Thread.currentThread() + " i=" + i);
            }
        }
    }

    static class MyExtendedThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Running Extended thread " + Thread.currentThread() + " i=" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Thread r1 = new Thread(new MyRunnableThread());

        r1.setName("First");
        Thread e1 = new MyExtendedThread();

        e1.setPriority(9);
        e1.setName("Second");
        Thread l1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread " + Thread.currentThread()
                        + " i="
                        + i);
            }
        });
        l1.setName("Third");
        System.out.println("threads created but not started");
        //r1.run();//do not call
        r1.start();
        e1.start();
        l1.start();

        r1.join();
        e1.join();
        l1.join();
        System.out.println("finish");
        //r1.setDaemon(true);
    }
}
