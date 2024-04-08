package edu.ithillel.multithreading.thread.synchronization;


import edu.ithillel.multithreading.thread.synchronization.examples.CodeExample;
import edu.ithillel.multithreading.thread.synchronization.examples.SimpleSynchronizationExample;
import edu.ithillel.multithreading.thread.synchronization.examples.StaticSynchronizationExample;

/**
 * Synchronization - is a tool that doesn`t allow two threads use same resource in the many threads at the moment
 * if some resource is used in this code.
 *
 * If first thread will execute some synchronized block of code or method, second thread will wait
 * while first will finish its execution.
 *
 * For synchronized resource "Lock" is created (Like key from toilet in public place). Only one
 * thread can have a "Lock" (key) from resource to use and modify it per moment.
 *
 * Monitor is like "Lock" but not for resource in method but for Class.
 */
public class ThreadSynchronization {
    public static void main(String[] args) {
        CodeExample example = new SimpleSynchronizationExample();
        //CodeExample example = new StaticSynchronizationExample();
        example.demonstrateProblem();
        example.demonstrateSynchronizationSolution();
    }
}
