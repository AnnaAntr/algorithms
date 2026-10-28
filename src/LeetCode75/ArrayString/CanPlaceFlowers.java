package LeetCode75.ArrayString;

// LeetCode #605
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[] {0, 0, 1, 0, 1}, 1));


        System.out.println(canPlaceFlowers(new int[] {1, 0, 0, 0, 0, 1}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int l = flowerbed.length;

        if (l == 1 && flowerbed[0] == 0 && n < 2)
            return true;
        if (l == 2 && flowerbed[0] == 0 && flowerbed[1] == 0 && n > 1)
            return false;

        if (flowerbed[0] == 0 && flowerbed[1] == 0)
            count++;

        int i = 2;
        while (i < l - 2) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    count++;
                    i += 2;
                    continue;
                }
            }
            i++;
        }

        if (flowerbed[l - 1] == 0 && flowerbed[l - 2] == 0)
            count++;

        return count >= n;
    }
}
