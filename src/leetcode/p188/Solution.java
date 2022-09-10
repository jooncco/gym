package leetcode.p188;

import java.util.Arrays;

public class Solution {
    private int n;
    private int[][] cache;

    public int maxProfit(int k, int[] prices) {
        n= prices.length;
        if (k >= n/2) return quickSolve(prices, k);

        cache= new int[n+1][k+1];
        for (int[] row : cache) Arrays.fill(row, -1);
        return findMaxProfit(prices, n-1, k);
    }

    private int findMaxProfit(final int[] prices, int endIdx, int k) {
        if (endIdx == -1 || k == 0) return 0;

        if (cache[endIdx][k] != -1) return cache[endIdx][k];
        cache[endIdx][k]= 0;
        for (int i=0; i < endIdx; ++i) {
            if (prices[i] < prices[endIdx]) {
                int spotProfit= prices[endIdx] - prices[i];
                cache[endIdx][k]= Math.max(cache[endIdx][k], findMaxProfit(prices, i-1, k-1) + spotProfit);
            } else {
                cache[endIdx][k]= Math.max(cache[endIdx][k], findMaxProfit(prices, i, k));
            }
        }
        return cache[endIdx][k];
    }

    private int quickSolve(final int[] prices, int k) {
        int maxProfit= 0;
        for (int i=1; i < n; ++i) {
            if (prices[i] > prices[i-1]) maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}