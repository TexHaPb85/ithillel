package edu.ithillel.oop.designPatterns.decorator.dataSourceDecorator.dataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileDataSource implements DataSource, DataSourceExt {
    private String fileName;

    public FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    public FileDataSource() {
    }

    @Override
    public void writeData(String data) {
        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        try (OutputStream fos = Files.newOutputStream(file.toPath())) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        File file = new File(this.fileName);
        return readFileContent(file);
    }

    @Override
    public String readData(String fileName) {
        File file = new File(fileName);
        return readFileContent(file);
    }

//    private String readFileContent(File file) {
//        char[] buffer = null;
//        try (FileReader reader = new FileReader(file)) {
//            buffer = new char[(int) file.length()];
//            reader.read(buffer);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return new String(buffer != null ? buffer : new char[0]);
//    }

    private void writeText(BufferedWriter bufferedWriter) {

    }

    private String readFileContent(File file){
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