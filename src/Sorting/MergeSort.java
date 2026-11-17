package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {15, 2, 0, 3, 1, 4, 8, 2, 1, 20, 9};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int nLeft = middle - left + 1;
        int nRight = right - middle;
        int[] leftArr = new int[nLeft];
        int[] rightArr = new int[nRight];

        System.arraycopy(array, left, leftArr, 0, nLeft);
        System.arraycopy(array, middle + 1, rightArr, 0, nRight);

        int l = 0, r = 0, i = left;

        while (l < nLeft && r < nRight) {
            if (leftArr[l] <= rightArr[r]) {
                array[i] = leftArr[l];
                l++;
            }
            else {
                array[i] = rightArr[r];
                r++;
            }
            i++;
        }

        while (l < nLeft) {
            array[i] = leftArr[l];
            l++; i++;
        }

        while (r < nRight) {
            array[i] = rightArr[r];
            r++; i++;
        }
    }
}
