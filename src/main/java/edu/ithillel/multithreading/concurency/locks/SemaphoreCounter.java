package edu.ithillel.multithreading.concurency.locks;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SemaphoreCounter {
    private Integer counter = 0;

    private Semaphore semaphore = new Semaphore(1);// number of threads that can wait for the resource

    public SemaphoreCounter() {
    }

    public int incrementCounter() {
        try {
            semaphore.acquire();
            ++counter;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            return counter;
        } finally {
            semaphore.release();
        }
        return counter;
    }

    public Integer getCounter() {
            return counter;
    }
}
