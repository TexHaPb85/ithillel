package edu.ithillel.io.c_bufferedStreams;

import edu.ithillel._constants.InputOutputConstants;

import java.io.*;

/**
 * Here demonstrated speed difference between simple file input/output streams and buffered input/output stream
 * to test it, paste your file (size should be at least 200 MB) into folder files/other/*  and set its name to constant:
 * edu.ithillel.io.aConstants.InputOutputConstants#BIG_FILE_INPUT
 * also rename constants
 * edu.ithillel.io.aConstants.InputOutputConstants#BIG_FILE_OUTPUT_BUFFER
 * edu.ithillel.io.aConstants.InputOutputConstants#BIG_FILE_OUTPUT_STREAM
 * set there any file names but set file type same as in BIG_FILE_INPUT
 * for example:
 *     String BIG_FILE_INPUT = "files/other/input.mkv";
 *     so output should also have type ".mkv":
 *     String BIG_FILE_OUTPUT_BUFFER = "files/other/output_buffer.mkv";
 *     String BIG_FILE_OUTPUT_STREAM = "files/other/output_stream.mkv";
 */
public class BufferedInputStreamSpeedTest {
    /**
     * For .mkv file with size 219 MB output is:
     * File read and written via buffer with time: 1344
     * File read and written via simple stream with time: 2470
     */
    public static void main(String[] args) {
        long startBuffer = System.currentTimeMillis();
        processFileInBuffer();
        long finishBuffer = System.currentTimeMillis();
        System.out.println("File read and written via buffer with time: " + (finishBuffer - startBuffer));

        long startStream = System.currentTimeMillis();
        processFileInSimpleStreams();
        long finishStream = System.currentTimeMillis();
        System.out.println("File read and written via simple stream with time: " + Math.abs(startStream - finishStream));
    }

    private static void readWriteStreams(InputStream fis, OutputStream fos) throws IOException {
        final int FOUR_KILOBYTES = 4096;
        byte[] buff = new byte[FOUR_KILOBYTES];
        int bytes = 0;
        bytes = fis.read(buff);
        while (bytes != -1) {
            fos.write(buff, 0, bytes);
            bytes = fis.read(buff);
        }
        fos.flush();
    }

    private static void processFileInSimpleStreams() {

        try (InputStream fis = new FileInputStream(InputOutputConstants.BIG_FILE_INPUT);
             OutputStream fos = new FileOutputStream(InputOutputConstants.BIG_FILE_OUTPUT_STREAM)) {
            readWriteStreams(fis, fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void processFileInBuffer() {
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(InputOutputConstants.BIG_FILE_INPUT));
             BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(InputOutputConstants.BIG_FILE_OUTPUT_BUFFER))) {
            readWriteStreams(fis, fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
