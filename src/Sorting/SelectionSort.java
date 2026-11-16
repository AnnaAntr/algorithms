package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[] {15, 2, 0, 3, 1, 4, 8, 2, 1, 20, 9};
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minInd = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minInd])
                    minInd = j;
            }

            int tmp = array[i];
            array[i] = array[minInd];
            array[minInd] = tmp;
        }
    }
}
