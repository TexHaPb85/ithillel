package edu.ithillel.io;

import java.io.*;
import java.util.Arrays;

public class BytesIOExample {
    public static void main(String[] args) {
        try(
                InputStream is = new FileInputStream("files/fileInProjectRoot.txt");
                OutputStream os = new FileOutputStream("files/outPut.pdf")
        ) {
            byte[] inputPdf = readBytes(is, os); // What is exception
            System.out.println(inputPdf);

            //writeOutputStream(os, inputPdf);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during reading/writing file: " + e.getMessage());
        }
    }

    private static byte[] readBytes(InputStream inputStream,OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[9999]; // number of bytes in IS, bad for big files
        int read;

        while ((read = inputStream.read(buffer, 0, buffer.length)) > 0) {
            outputStream.write(buffer, 0, read);
            outputStream.flush();
        }
        return buffer;
    }

    private static void writeOutputStream(OutputStream outputStream, byte[] bytes) throws IOException {
        outputStream.write(bytes);
        outputStream.flush();//clear
    }
}
