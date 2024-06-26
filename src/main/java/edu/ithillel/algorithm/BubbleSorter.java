package edu.ithillel.algorithm;

/**
 * O(n * n)
 */
public class BubbleSorter extends Sorter {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}
