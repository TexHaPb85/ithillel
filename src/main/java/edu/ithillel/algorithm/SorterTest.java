package edu.ithillel.algorithm;

public class SorterTest {
    public static void main(String[] args) {
        int[] array = {10, 2, 10, 3, 1, 2, 5, 64, 34, 25, 12, 22, 11, 90};
        Sorter sorter = new QuickSorter();
        sorter.sort(array);
        sorter.printArray(array);
    }
}
