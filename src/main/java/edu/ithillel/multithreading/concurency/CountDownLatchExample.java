package edu.ithillel.multithreading.concurency;

import edu.ithillel.multithreading.concurency.locks.ReadWriteCounter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                atomicInteger.incrementAndGet();
            }
            countDownLatch.countDown();
        });
        t1.start();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                atomicInteger.incrementAndGet();
            }
            countDownLatch.countDown();
        }).start();

//        t1.join();
//        t2.join();
        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }
}
