package LeetCode75.TwoPointers;

import java.util.Arrays;

// LeetCode #283
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        for (int i = insertPos; i < nums.length; i++)
            nums[i] = 0;
    }
}
