package Search;

// LeetCode #704
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));
        System.out.println(search(new int[] {1}, 1));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int half;

        while (left <= right) {
            half = (left + right) / 2;
            if (nums[half] == target)
                return half;
            else if (nums[half] < target) {
                left = half + 1;
            }
            else if (nums[half] > target) {
                right = half - 1;
            }
        }

        return -1;
    }
}
