package HashMap;

import java.util.HashMap;
import java.util.Map;

// LeetCode #217
public class ContainsDuplicates {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,2,3,1}));
        System.out.println(containsDuplicate(new int[] {1,2,3,4}));
        System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            int count = hashMap.getOrDefault(num, 0);

            if (count > 0)
                return true;

            hashMap.put(num, 1);
        }

        return false;
    }
}
