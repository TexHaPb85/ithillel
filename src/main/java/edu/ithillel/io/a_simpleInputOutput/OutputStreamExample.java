package edu.ithillel.io.a_simpleInputOutput;

import edu.ithillel._constants.InputOutputConstants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class OutputStreamExample {
    public static void main(String[] args) {

        try(OutputStream outputStream = new FileOutputStream(InputOutputConstants.FILE_FOR_WRITING_PATH)) {
            String textWeWantToWrite = "Some текст, що ми хочемо записати\non different languages!";
            writeOutputStream(outputStream, textWeWantToWrite);
        /**
         * If outputStream cannot find file by the path it creates the new one.
         * FileNotFoundException for OutputStream can occur if
         * - the file exists but is a directory rather than a regular file,
         * - does not exist but cannot be created,
         * - cannot be opened for any other reason(for example access denied for current system user)
         * Access denied to file can be set up using OS tools by cmd or using File.setWritable()
         * see FileBlockerUtil .
         */
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during reading/writing file: " + e.getMessage());
        }
    }

    private static void writeOutputStream(OutputStream outputStream, String text) throws IOException {
        byte[] bytes = text.getBytes();
        outputStream.write(bytes);
        outputStream.flush();//clear outputStream
    }
}
