package Sorting;

import java.util.Arrays;

public class ShakerSort {
    public static void main(String[] args) {
        int[] array = new int[] {15, 2, 0, 3, 1, 4, 8, 2, 1, 20, 9};
        System.out.println(Arrays.toString(array));
        shakerSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shakerSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int tmp;

        while (left <= right) {
            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }
            left++;

            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
            right--;
        }
    }
}
