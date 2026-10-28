package LeetCode75.ArrayString;

import java.util.ArrayList;
import java.util.List;

// LeetCode #1431
public class KidsWithCandies {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[] {4, 2, 1, 1, 2}, 1));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        List<Boolean> res = new ArrayList<>();

        for (int candy: candies) {
            if (candy > max)
                max = candy;
        }

        for (int candy: candies) {
            if (candy + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }

        return res;
    }
}
