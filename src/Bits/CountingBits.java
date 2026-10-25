package Bits;

import java.util.Arrays;

// LeetCode #338
public class CountingBits {
    public static void main(String[] args) {
        int[] res = countBits(5);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            ans[i] = hammingWeight(i);
        }

        return ans;
    }

    public static int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }
}
