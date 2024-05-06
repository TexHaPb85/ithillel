package edu.ithillel.generics;

public class ContainerUtils {
    public static <T extends Number> GenericContainer<T> createNumberContainer(T value) {
        return new GenericContainer<>(value);
    }

    public static <T extends Number> GenericContainer<String> createStringContainer(T value) {
        String string = new GenericContainer<>(value).getInputType().toString();
        return new GenericContainer<String>(string);
    }
}
