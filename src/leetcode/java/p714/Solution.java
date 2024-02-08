package leetcode.java.p714;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

/**
 * State Machine
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n], sell = new int[n], hold = new int[n], stay = new int[n];
        buy[0] = -prices[0];
        sell[0] = hold[0] = -100001;
        stay[0] = 0;
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int prevMaxWithStock = Math.max(buy[i - 1], hold[i - 1]);
            int prevMaxWithoutStock = Math.max(sell[i - 1], stay[i - 1]);
            buy[i] = prevMaxWithoutStock - prices[i];
            sell[i] = prevMaxWithStock + prices[i] - fee;
            hold[i] = prevMaxWithStock;
            stay[i] = prevMaxWithoutStock;
            ans = Math.max(ans, Math.max(Math.max(buy[i], sell[i]), Math.max(hold[i], stay[i])));
        }
        return ans;
    }
}