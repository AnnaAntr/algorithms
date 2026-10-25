package Bits;

// LeetCode #190
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>>= 1;
        }

        return res;
    }
}
