package edu.ithillel.generics;

public class NumberContainer <T extends Number> {
    private T number;

    public NumberContainer(T number) {
        this.number = number;
    }

    public NumberContainer() {
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NumberContainer{" +
                "number=" + number +
                '}';
    }
}
