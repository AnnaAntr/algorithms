package PrefixSumm;

// LeetCode #303
public class RangeSumQuery {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {
        int[] nums;
        int[] prefix;

        public NumArray(int[] nums) {
            this.nums = nums;

            prefix = new int[nums.length];
            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                prefix[i] = prefix[i - 1] + nums[i];
        }

        public int sumRange(int left, int right) {
            if (left == 0)
                return prefix[right];

            return prefix[right] - prefix[left - 1];
        }
    }
}
