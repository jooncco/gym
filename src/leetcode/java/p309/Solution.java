package leetcode.java.p309;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class Solution {
    private final int EMPTY = 0, HOLDING = 1, REST = 2;
    private int[][] cache;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        cache = new int[n][3];
        cache[0][HOLDING] = -prices[0];
        for (int i = 1; i < n; ++i) {
            cache[i][EMPTY] = Math.max(cache[i - 1][EMPTY], cache[i - 1][REST]);
            cache[i][HOLDING] = Math.max(cache[i - 1][EMPTY] - prices[i], cache[i - 1][HOLDING]);
            cache[i][REST] = cache[i - 1][HOLDING] + prices[i];
        }
        int ans = 0;
        for (int state = 0; state < 3; ++state) {
            ans = Math.max(ans, cache[n - 1][state]);
        }
        return ans;
    }
}