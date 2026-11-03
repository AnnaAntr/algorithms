package LeetCode75.PrefixSum;

// LeetCode #1732
public class HighestAltitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] {-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude(new int[] {-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int prev = 0;
        int curr;

        for (int i = 0; i < gain.length; i++) {
            curr = prev + gain[i];

            if (curr > max) max = curr;

            prev = curr;
        }

        return max;
    }
}
