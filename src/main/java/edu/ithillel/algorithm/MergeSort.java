package edu.ithillel.algorithm;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array; // Base case: array is already sorted or empty
        }

        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, temp, left, mid); // Sort left half
            mergeSort(array, temp, mid + 1, right); // Sort right half

            merge(array, temp, left, mid, right); // Merge sorted halves
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        // Copy both halves into the temporary array
        System.arraycopy(array, left, temp, left, right - left + 1);

        int i = left; // Initial index of first subarray
        int j = mid + 1; // Initial index of second subarray
        int k = left; // Initial index of merged array

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        // Copy remaining elements of left subarray (if any)
        while (i <= mid) {
            array[k++] = temp[i++];
        }

        // Copy remaining elements of right subarray (if any)
        while (j <= right) {
            array[k++] = temp[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 2, 4, 1, 8, 6};
        mergeSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}