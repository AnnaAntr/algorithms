package PrefixSumm;

import java.util.Arrays;

// LeetCode #1480
public class RunningSum {
    public static void main(String[] args) {
        int[] result = runningSum(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(result));

        result = runningSum(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(Arrays.toString(result));
    }

    public static int[] runningSum(int[] nums) {
        int[] summs = new int[nums.length];

        summs[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            summs[i] = summs[i - 1] + nums[i];

        return summs;
    }
}
