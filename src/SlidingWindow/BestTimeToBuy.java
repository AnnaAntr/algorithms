package SlidingWindow;

// LeetCode # 121
public class BestTimeToBuy {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int bestToSell = 0;

        while (sell < prices.length) {
            if (prices[sell] <= prices[buy]) {
                buy = sell;
                sell++;
            }
            else if (prices[sell] > prices[buy]) {
                bestToSell = Math.max(prices[sell] - prices[buy], bestToSell);
                sell++;
            }
        }

        return bestToSell;
    }
}
