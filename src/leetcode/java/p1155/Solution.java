package leetcode.java.p1155;
// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

import java.util.Arrays;

/**
 * DP (Top-down)
 * | Time: O(nk^2)
 * | Space: O(nk)
 */
public class Solution {
    private final int MOD = (int) 1e9 + 7;
    private int n, k;
    private int[][] cache;

    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        cache = new int[n][target + 1];
        for (int i = 0; i < n; ++i)
            Arrays.fill(cache[i], -1);
        return countWays(0, target);
    }

    private int countWays(int idx, int targetSum) {
        if (idx >= n) {
            if (targetSum == 0)
                return 1;
            return 0;
        }

        if (cache[idx][targetSum] > -1)
            return cache[idx][targetSum];
        cache[idx][targetSum] = 0;
        for (int i = 1; i <= Math.min(k, targetSum); ++i) {
            cache[idx][targetSum] = (cache[idx][targetSum] + countWays(idx + 1, targetSum - i)) % MOD;
        }
        return cache[idx][targetSum];
    }
}