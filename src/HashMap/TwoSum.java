package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LeetCode #1
public class TwoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));

        result = twoSum(new int[] {3, 3}, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i};
            }

            hashMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
