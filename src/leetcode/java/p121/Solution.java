package leetcode.java.p121;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, minSoFar = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (minSoFar < prices[i]) {
                ans = Math.max(ans, prices[i] - minSoFar);
            }
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return ans;
    }
}