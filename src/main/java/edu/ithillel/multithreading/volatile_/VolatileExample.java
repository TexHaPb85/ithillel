package edu.ithillel.multithreading.volatile_;

public class VolatileExample {
    private static int value = 0;
    private static volatile boolean isReady = false;
    public static void main(String[] args) throws InterruptedException {
        /**
         * some code instructions that read from RAM memory often can be saved in processor local cache to increase speed
         * for example here isReady will be checked really often so this var will be saved in processor local cache
         * when at some moment we will set isReady to true, it will be still read from processor local cache for some time
         * we should mark isReady as "volatile" variable so it will be every time read from the RAM
         */
        new Thread(() -> {
            int counterIterations = 0;
            while (!isReady) {
                //Thread.yield(); // set thread to Runnable state and scheduler will decide when to make it running again
                System.out.println("yielding: " + ++counterIterations);
            }
            System.out.println("val: " + value);
        }).start();
        Thread.sleep(500);
        value =34;
        isReady = true;
        System.out.println("main is finished");
    }
}
