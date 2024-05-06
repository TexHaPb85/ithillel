package edu.ithillel.multithreading.thread.states;

import edu.ithillel.multithreading.thread.states.examples.*;

/**
 * "new" first state of thread
 * then thread transferred to thread`s pool
 * "runnable" - state of thread in thread`s pool when it is waiting for start
 * "running" - state of thread in thread`s pool when it is running
 * !only one thread can be in running state at the moment!
 * "waiting/blocked/sleeping" - state of thread in thread`s pool when it is waiting for something to continue its execution
 *
 */
public class ThreadStates {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            CodeExample example = new YieldExample();
            example.demonstrateExample();

        }

        //thread.interrapt();//set flag isInterrapted to true
        //Thread.currentThread().isInterrupted();

    }
}
