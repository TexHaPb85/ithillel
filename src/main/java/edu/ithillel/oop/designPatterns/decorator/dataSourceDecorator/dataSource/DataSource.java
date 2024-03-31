package edu.ithillel.oop.designPatterns.decorator.dataSourceDecorator.dataSource;

public interface DataSource {
    void writeData(String data);

    String readData();
}
