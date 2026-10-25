package Bits;

public class NumberOfBits {
    public static void main(String[] args) {
        System.out.println(count(128));
    }

    public static int count(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n = n >> 1;
        }

        return count;
    }
}