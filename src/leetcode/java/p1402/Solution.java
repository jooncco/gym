package leetcode.java.p1402;
// https://leetcode.com/problems/reducing-dishes/

import java.util.Arrays;

public class Solution {
    private int n;
    private int[][] cache;

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        n = satisfaction.length;
        cache = new int[n][n + 1]; // [idx, time]
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= n; ++j) {
                cache[i][j] = -1;
            }
        }
        return findMax(satisfaction, 0, 1);
    }

    private int findMax(int[] satisfaction, int idx, int time) {
        if (idx >= n)
            return 0;
        if (cache[idx][time] > -1)
            return cache[idx][time];

        cache[idx][time] = Math.max(
                findMax(satisfaction, idx + 1, time),
                satisfaction[idx] * time + findMax(satisfaction, idx + 1, time + 1));
        return cache[idx][time];
    }
}