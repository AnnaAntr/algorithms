package Sorting;

import java.util.Arrays;

public class CombSort {
    public static void main(String[] args) {
        int[] array = new int[] {15, 2, 0, 3, 1, 4, 8, 2, 1, 20, 9};
        System.out.println(Arrays.toString(array));
        combSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void combSort(int[] array) {
        double factor = 1.247;
        int n = array.length - 1;
        int step = (int) (n / factor);
        int tmp;

        while (step >= 1) {
            for (int i = 0; i + step < n; i++) {
                if (array[i] > array[i + step]) {
                    tmp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = tmp;
                }
            }

            step = (int) (step / factor);
        }
    }
}
