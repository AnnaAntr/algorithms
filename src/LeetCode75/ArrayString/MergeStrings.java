package LeetCode75.ArrayString;

// LeetCode # 1768
public class MergeStrings {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pq"));
        System.out.println(mergeAlternately("abcd", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        StringBuilder res = new StringBuilder();

        while (p1 < word1.length() || p2 < word2.length()) {
            if (p1 < word1.length())
                res.append(word1.charAt(p1++));

            if (p2 < word2.length())
                res.append(word2.charAt(p2++));
        }

        return res.toString();
    }
}
