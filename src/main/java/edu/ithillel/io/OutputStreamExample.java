package edu.ithillel.io;

import java.io.*;
import java.util.Arrays;

public class OutputStreamExample {
    public static void main(String[] args) {
        File file = new File("files/out.txt");
        System.out.println(file.getUsableSpace());
        if(!file.canWrite()){
            System.out.println(file.setWritable(true, true));
        }

        try(
                InputStream is = new FileInputStream("files/fileInProjectRoot.txt");
                OutputStream os = new FileOutputStream("files/out.txt")
        ) {
            String textFromFile = readInputStream(is); // What is exception
            System.out.println(textFromFile);

            textFromFile = " --- modified";
            writeOutputStream(os, textFromFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during reading/writing file: " + e.getMessage());
        }
    }

    private static void writeOutputStream(OutputStream outputStream, String text) throws IOException {
        byte[] bytes = text.getBytes();
        outputStream.write(bytes);
        outputStream.flush();//clear
    }

    private static String readInputStream (InputStream inputStream) throws IOException {
        String text = "";
        //int available = inputStream.available(); // how much more bytes can we read (should be > 0)
        int read = inputStream.read(); // reads 1 next byte of IS int value 0...255
        while (read != -1) {
            text += (char)read;
            //System.out.println((char)read);
            read = inputStream.read();
        }

        return text;
    }


}
