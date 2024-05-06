package edu.ithillel.oop.designPatterns.decorator;

import edu.ithillel.oop.designPatterns.decorator.dataSourceDecorator.*;
import edu.ithillel.oop.designPatterns.decorator.dataSourceDecorator.dataSource.DataSource;
import edu.ithillel.oop.designPatterns.decorator.dataSourceDecorator.dataSource.FileDataSource;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSource dataSource = new FileDataSource("files/decoratorExample.txt");
//        dataSource.writeData(salaryRecords);
//        System.out.println(dataSource.readData());

        DataSource encryptionDecorator = new EncryptionDecorator(dataSource);
        encryptionDecorator.writeData(salaryRecords);

        System.out.println(encryptionDecorator.readData());

//        DataSourceDecorator encoded = new CompressionDecorator(
//                new EncryptionDecorator(
//                        new FileDataSource("out/OutputDemo.txt")));


//        DataSourceDecorator encoded
//                = new EncryptionDecorator(new FileDataSource("OutputDemoEncoded.txt"));
//        encoded.writeData(salaryRecords);
//
//        CompressionDecorator compressed
//                = new CompressionDecorator(new FileDataSource("OutputDemoCompressed.txt"));
//        compressed.writeData(salaryRecords);
//
//
//        FileDataSource plain = new FileDataSource();
//
//        System.out.println("- Input ----------------");
//        System.out.println(salaryRecords);
//        System.out.println("- Encoded --------------");
//        System.out.println(plain.readData("OutputDemoEncoded.txt"));
//        System.out.println("- Decoded --------------");
//        System.out.println(encoded.readData());
//        System.out.println("- Compressed --------------");
//        System.out.println(plain.readData("OutputDemoCompressed.txt"));
//        System.out.println("- Decompressed --------------");
//        System.out.println(compressed.readData());
    }
}