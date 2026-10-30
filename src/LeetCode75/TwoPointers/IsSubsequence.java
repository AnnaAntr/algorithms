package LeetCode75.TwoPointers;

// LeetCode #392
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int ps = 0;
        int pt = 0;

        while (ps < s.length()) {
            while (pt < t.length() && t.charAt(pt) != s.charAt(ps)) pt++;

            if (pt >= t.length()) return false;

            ps++; pt++;
        }

        return true;
    }
}
