package PrefixSumm;

import java.util.Arrays;

// LeetCode #238
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(result));

        result = productExceptSelf(new int[] {-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(result));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = nums[0];
        postfix[n - 1] = nums[n - 1];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            prefix[i] = prefix[i - 1] * nums[i];
            postfix[j] = postfix[j + 1] * nums[j];
        }

        int[] answer = new int[n];
        answer[0] = postfix[1];
        for (int i = 1; i < n - 1; i++)
            answer[i] = prefix[i - 1] * postfix[i + 1];
        answer[n - 1] = prefix[n - 2];

        return answer;
    }
}
