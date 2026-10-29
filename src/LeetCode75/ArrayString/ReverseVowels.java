package LeetCode75.ArrayString;

import java.util.HashSet;
import java.util.Set;

// LeetCode #345
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] str = s.toCharArray();

        int left = 0;
        int right = str.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(str[left])) left++;
            while (left < right && !vowels.contains(str[right])) right--;

            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++; right--;
        }

        return new String(str);
    }
}
