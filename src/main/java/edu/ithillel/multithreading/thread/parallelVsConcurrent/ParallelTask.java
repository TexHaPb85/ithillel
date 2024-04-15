package edu.ithillel.multithreading.thread.parallelVsConcurrent;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParallelTask {

    static class ThreadForReadingFiles extends Thread {
        public String filePath;
        public StringBuilder sb;

        public ThreadForReadingFiles(String filePath, StringBuilder sb) {
            super();
            this.filePath = filePath;
            this.sb = sb;
        }

        public StringBuilder getSb() {
            return sb;
        }

        public ThreadForReadingFiles(String filePath) {
            super();
            this.filePath = filePath;
        }

        @Override
        public void run() {
            //read two files and concat them to single one
            try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(filePath)))) {
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner.hasNext()) {
                    stringBuilder.append(scanner.nextLine()).append("\n");
                }
                if(sb != null) {
                    stringBuilder.append(sb);
                    System.out.println(stringBuilder);
                    return;
                }
                System.out.println(stringBuilder);
            } catch (FileNotFoundException e) {
                System.out.println("Error during reading file with scanner: " + e.getMessage());
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String data1Path = rootPath + "thread/data1.txt";
        String data2Path = rootPath + "thread/data2.txt";

        ThreadForReadingFiles t1 = new ThreadForReadingFiles(data1Path);
        ThreadForReadingFiles t2 = new ThreadForReadingFiles(data2Path);
        t1.start();
        t2.start();

        //t1.setDaemon(true);
        t1.join();
        t2.join();

        StringBuilder res = new StringBuilder();
        res.append(t1.getSb()).append(t2.getSb());

        System.out.println(res);
    }
}
