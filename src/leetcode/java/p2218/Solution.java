package leetcode.java.p2218;
// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/

import java.util.List;

/**
 * Dynamic Programming (Top-down)
 * | Time: O (n * len(sum(piles[i].size()))
 * | Space: O (n * k)
 */
public class Solution {
    private int[][] cache;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        cache = new int[piles.size()][k + 1];
        for (int i = 0; i < cache.length; ++i) {
            for (int j = 0; j < cache[0].length; ++j) {
                cache[i][j] = -1;
            }
        }
        return findMaxValue(piles, 0, k);
    }

    private int findMaxValue(List<List<Integer>> piles, int from, int k) {
        if (from >= piles.size() || k == 0)
            return 0;
        if (cache[from][k] > -1)
            return cache[from][k];

        cache[from][k] = findMaxValue(piles, from + 1, k);
        int curAmount = 0;
        for (int i = 0; i < Math.min(piles.get(from).size(), k); ++i) {
            curAmount += piles.get(from).get(i);
            cache[from][k] = Math.max(cache[from][k], curAmount + findMaxValue(piles, from + 1, k - i - 1));
        }
        return cache[from][k];
    }
}