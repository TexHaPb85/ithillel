package edu.ithillel.io.aSimpleInputOutput;

import edu.ithillel.io._constants.InputOutputConstants;

import java.io.*;
import java.util.Arrays;

public class InputStreamExample {

    public static void main(String[] args) {
    /**
     * Try with resources can receive any amount of Closeable interface implementations.
     * After finishing try-catch-final blocks method Closeable.close() will be automatically called.
     * In this example we have 2 InputStreams because after reading it at ones we cannot read it again,
     * so we get input stream for same file twice to read it by different ways.
     */
        try (
                InputStream inputStreamForByteByByteReading = new BufferedInputStream(new FileInputStream(InputOutputConstants.FILE_FOR_READING_PATH));
                InputStream inputStreamForBufferReading = new FileInputStream(InputOutputConstants.FILE_FOR_READING_PATH)
        ) {
            String byteByByteInputStreamResult = readInputStreamByteByByte(inputStreamForByteByByteReading);
            String bufferInputStreamResult = readInputStreamInBuffer(inputStreamForBufferReading);
            System.out.println("Byte by byte reading: " + byteByByteInputStreamResult);
            System.out.println("Buffer reading result: " + bufferInputStreamResult);

            /**
             * FileInputStream should be closed to return file descriptor back to operating system,
             * automatically called after try with resources so there no need to call it manually here
             */
            //inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during reading file: " + e.getMessage());
        }
    }

    public static String readInputStreamByteByByte(InputStream inputStream) throws IOException {
        String text = "";
        int read = inputStream.read(); // reads 1 next byte of inputStream as int value from 0 to 255
        while (read != -1) {
            text += (char)read; // int value can be cast to char, because every char contains integer correspondence
            //System.out.println((char)read);
            read = inputStream.read();
        }

        return text;
    }

    private static String readInputStreamInBuffer(InputStream inputStream) throws IOException {
        String text = "";
        int numberOfBytesInIS = inputStream.available(); // how much more bytes can be read (should be > 0)
        System.out.println(numberOfBytesInIS); // number of bytes in inputStream
        byte[] buffer = new byte[numberOfBytesInIS]; //for huge files of size 100MB and more RAM that was allocated for java will run out
        while(true) {
            int read = inputStream.read(buffer); // for such signature {buffer.length} bytes will be taken from IS and put into buffer
            if(read != -1) {
                text += new String(Arrays.copyOf(buffer, read));
            } else {
                break;
            }
        }
        return text;
    }
}
