package edu.ithillel.generics;

import java.lang.reflect.Array;
import java.util.Objects;

public class GenericContainer<T> {
    private T inputT;
    private T[] inputsT;

    public GenericContainer(T inputT) {

        this.inputT = inputT;
    }

    public GenericContainer() {
    }

    public GenericContainer(Class<T> clazz) {
        this.inputsT = (T[]) Array.newInstance(clazz, 10);

    }

    public T getInputType() {
        return inputT;
    }

    public void setInputType(T inputT) {
        this.inputT = inputT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericContainer<?> that = (GenericContainer<?>) o;
        return Objects.equals(inputT, that.inputT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputT);
    }

    @Override
    public String toString() {
        return "GenericContainer{" +
                "inputType=" + inputT +
                '}';
    }
}
