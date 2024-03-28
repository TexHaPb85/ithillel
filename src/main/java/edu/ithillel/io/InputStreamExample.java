package edu.ithillel.io;

import java.io.*;
import java.util.Arrays;

public class InputStreamExample {

    public static void main(String[] args) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("files/fileInProjectRoot.txt")); // try with resources
            //String textFromFile = readInputStream(is); // What if exception? is.close?
            String textFromFile = readInputStreamInBuffer(is);
            System.out.println(textFromFile);

            is.close(); //FileInputStream should be closed to return file descriptor back to Operation System
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during reading file: " + e.getMessage());
        }
    }

    public static String readInputStream (InputStream inputStream) throws IOException {
        String text = "";

        //int available = inputStream.available(); // how much more bytes can we read (should be > 0)
        int read = inputStream.read(); // reads 1 next byte of IS int value 0...255
        while (read != -1) {
            text += (char)read;
            System.out.println((char)read);
            read = inputStream.read();
        }

        return text;
    }

    private static String readInputStreamInBuffer(InputStream inputStream) throws IOException {
        String text = "";
        //System.out.println(inputStream.available());
        byte[] buffer = new byte[inputStream.available()]; // number of bytes in IS, bad for big files
        int read;

        while(true) {
            read = inputStream.read(buffer);
            if(read != -1) {
                text += new String(Arrays.copyOf(buffer, read));
            } else {
                break;
            }
        }
        return text;
    }
}
