package edu.ithillel.multithreading.thread.parallelConcurentTask;

public class ConcurrentTask {
    //Counter - is same resource for two threads every of them should increment it to 200_000 result will be less
    public static void main(String[] args) throws InterruptedException {
        Num n1 = new Num();
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                n1.increaseInt();
            }

        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                n1.increaseInt();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(n1.i);
    }

    static class Num {
        Integer i =0;
        public  Integer increaseInt() {
            //synchronized (this){
                return i++;
            //}

        }
    }


}
