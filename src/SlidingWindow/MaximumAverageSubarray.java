package SlidingWindow;

// LeetCode #643
public class MaximumAverageSubarray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[] {0, 1, 1, 3, 3}, 4));
        System.out.println(findMaxAverage(new int[] {5}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++)
            maxSum += nums[i];

        int left = 1;
        int right = k;
        int currSum = maxSum;

        while (right < nums.length) {
            currSum = currSum - nums[left - 1] + nums[right];
            maxSum = Math.max(maxSum, currSum);
            left++; right++;
        }

        return (double) maxSum / k;
    }
}
