package LeetCode75.SlidingWindow;

// LeetCode #724
public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[] {1, 2, 3}));
    }

    public static int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        if (prefix[nums.length - 1] - prefix[0] == 0)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (prefix[i - 1] == prefix[nums.length - 1] - prefix[i])
                return i;
        }

        return -1;
    }
}
