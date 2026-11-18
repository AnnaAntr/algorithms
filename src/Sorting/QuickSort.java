package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {15, 2, 0, 3, 1, 4, 8, 2, 1, 20, 9};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotInd = partition(array, low, high);

            quickSort(array, low, pivotInd - 1);
            quickSort(array, pivotInd + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        int tmp;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                i++;
            }
        }

        tmp = array[i];
        array[i] = array[high];
        array[high] = tmp;

        return i;
    }
}