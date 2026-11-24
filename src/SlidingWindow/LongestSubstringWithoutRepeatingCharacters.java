package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcbb"));
    }

    public static int longestUniqueSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (hashMap.containsKey(c) && hashMap.get(c) >= left)
                left = hashMap.get(c) + 1;

            hashMap.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
