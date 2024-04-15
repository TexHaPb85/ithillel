package edu.ithillel.multithreading.thread.parallelVsConcurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentTask {
    /**
     * Counter - is same resource for two threads every of them should increment it to 200_000 result will be less
     * This is example of race condition and how it can be resolved with synchronization or atomic variables
     */

    public static void main(String[] args) throws InterruptedException {
        Num n1 = new Num();
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 100_000; j++) {
                n1.increaseInt();
            }

        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 100_000; j++) {
                n1.increaseInt();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //System.out.println(n1.ai);
        System.out.println(n1.ai);
    }

    static class Num {
        AtomicInteger ai = new AtomicInteger(0);
        int i;
        public Integer increaseInt() {
            //synchronized (this) {
                //return i++;
            //}
            return ai.incrementAndGet();

        }
    }


}
