package edu.ithillel.algorithm;

public class MergeSorter extends Sorter {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        // Copy both halves into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low; // Pointer for the left subarray
        int j = middle + 1; // Pointer for the right subarray
        int k = low; // Pointer for the merged array

        // Merge the two halves back into the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            array[k] = helper[i];
            k++;
            i++;
        }
    }

}
