package edu.ithillel.io;

import java.io.*;
import java.util.Arrays;

public class FileReaderExample {
    public static void main(String[] args) {
        //OutputStream os = new FileOutputStream("resources/io/fileInProjectRoot.txt");
//        File file = new File("src/main/resources/io/fileInProjectRoot.txt");
//        System.out.println(readFileContent(file));

//        File file = new File("files/fileInProjectRoot.txt");
//        String s = readFileContent(file);
//        System.out.println(s);
//        writeFileContent(file, s+"---modified");
    }

    private static void writeFileContent(File file, String content){
        //try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        try (FileWriter writer = new FileWriter(file)){
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String readFileContent(File file){
        char[] buffer = null;
        StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
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
}
