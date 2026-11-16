package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {15, 2, 0, 3, 1, 4, 8, 2, 1, 20, 9};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];

            int j = i;
            while (j > 0 && array[j - 1] > curr) {
                array[j] = array[j - 1];
                j--;
            }
            
            array[j] = curr;
        }
    }
}
