package edu.ithillel.io.b_textFileReaderWriter;

import edu.ithillel._constants.InputOutputConstants;

import java.io.*;
import java.util.Arrays;

public class TextFileReaderWriterExample {
    public static void main(String[] args) {
        File readinFile = new File(InputOutputConstants.FILE_FOR_READING_PATH);
        File writingFile = new File(InputOutputConstants.FILE_FOR_WRITING_PATH);
        String readText = readFileContent(readinFile);
        writeFileContent(writingFile, readText + " modified in Java");
    }

    /**
     * BufferedWriter has same logic as BufferedInputStream - decorator for plain Writer that increase performance
     */
    private static void writeFileContent(File file, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error during writing text to file: " + e.getMessage());
        }
    }

    /**
     * BufferedReader has same logic as BufferedOutputStream - decorator for plain Reader that increase performance
     */
    private static String readFileContent(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            char[] buffer = new char[(int) file.length()];
            int read = reader.read(buffer);

            while (read != -1) {
                sb.append(Arrays.copyOf(buffer, read));
                read = reader.read(buffer);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }

    private static String readFileContentLineByLine(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String nextLine = "";
            while (nextLine != null) {
                nextLine = reader.readLine();
                sb.append(nextLine);
            }
        } catch (IOException ex) {
            System.out.println("Error during reading file: " + file.getPath() + " - " + ex.getMessage());
        }
        return sb.toString();
    }
}
