package edu.ithillel.multithreading.concurency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private Integer counter = 0;

    //fair - means that next that that will get monitor after locker.unlock(); will be the thread that waited longer time
    private Lock readLocker;
    private Lock writeLocker;

    public ReadWriteCounter() {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        writeLocker = readWriteLock.writeLock(); // write lock can be taken only by 1 thread at the moment
        readLocker = readWriteLock.readLock(); // read lock can be taken by multiple threads at the moment if writeLocker is not taken
    }

    public int incrementCounter() {

        writeLocker.lock();
        try {
            ++counter;
        } catch (Exception e) {

        } finally {
            writeLocker.unlock();
        }

        return counter;
    }

    public Integer getCounter() {
        try {
            readLocker.lock();
            return counter;
        } finally {
            readLocker.unlock();
        }
    }
}
