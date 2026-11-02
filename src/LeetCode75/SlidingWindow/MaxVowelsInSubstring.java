package LeetCode75.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

// LeetCode #1456
public class MaxVowelsInSubstring {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("leetcode", 2));
        System.out.println(maxVowels("aeiou", 2));
    }

    public static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int curVowels = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                curVowels++;
        }

        if (curVowels > maxVowels)
            maxVowels = curVowels;

        int start = 1;
        int end = start + k - 1;

        while (end < s.length()) {
            if (isVowel(s.charAt(start - 1)))
                curVowels--;
            if (isVowel(s.charAt(end)))
                curVowels++;

            if (curVowels > maxVowels)
                maxVowels = curVowels;

            start++; end++;
        }

        return maxVowels;
    }

    public static boolean isVowel(char ch) {
        List<Character> list = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
        return list.contains(ch);
    }
}
