package edu.ithillel;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        if(args[0].equals("one")){
            System.out.println("1");
        }
        Arrays.asList(args).forEach(System.out::println);
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\");
        for (int i = 0; i < 10; i++) {
            System.out.println("iteration i" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}