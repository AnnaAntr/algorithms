package DynamicProgramming;

// LeetCode #70
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n <= 2)
            return n;

        int prev1 = 2;    // 1 step back
        int prev2 = 1;    // 2 steps back
        int res = 0;
        for (int i = 3; i < n + 1; i++) {
            res = prev1 + prev2;
            prev2 = prev1;
            prev1 = res;
        }

        return res;
    }
}
