package PrefixSumm;

// LeetCode #1991
public class MiddleIndex {
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[] {2, 3, -1, 8, 4}));

        System.out.println(findMiddleIndex(new int[] {1, -1, 4}));

        System.out.println(findMiddleIndex(new int[] {4, 0}));

        System.out.println(findMiddleIndex(new int[] {1}));
    }

    public static int findMiddleIndex(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        if ((prefix[nums.length - 1] - prefix[0] == 0))
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (prefix[i - 1] == (prefix[nums.length - 1] - prefix[i]))
                return i;
        }

        return -1;
    }
}
