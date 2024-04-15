package edu.ithillel.multithreading.concurency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCounter {
    private Integer counter = 0;

    //fair - means that next that that will get monitor after locker.unlock(); will be the thread that waited longer time
    private Lock locker = new ReentrantLock(true);

    public /*synchronized*/ int incrementCounter() {
        //synchronized (this) {
        boolean b;
        while (!(b = locker.tryLock())) {
            System.out.println("doing something else");
        }
        locker.lock();
        try {
            ++counter;
            return counter;
        } catch (Exception e) {

        } finally {
            locker.unlock();
        }

        //}
        return counter;
    }

    public Integer getCounter() {
        return counter;
    }
}
