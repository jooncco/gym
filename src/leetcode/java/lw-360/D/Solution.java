package leetcode.java.lw-360.D;
// https://leetcode.com/contest/weekly-contest-360/problems/maximize-value-of-function-in-a-ball-passing-game/

import java.util.*;

/**
 * DP (Binary Lifting)
 * | Time: O(nlog(k))
 * | Space: O(nlog(k))
 */
public class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        final int MAX_H = 40;
        final int n = receiver.size();
        int[][] p = new int[MAX_H][n];
        long[][] cc = new long[MAX_H][n];
        for (int i = 0; i < n; ++i) {
            p[0][i] = receiver.get(i);
            cc[0][i] = receiver.get(i);
        }
        for (int i = 1; i < MAX_H; ++i) {
            for (int j = 0; j < n; ++j) {
                p[i][j] = p[i - 1][p[i - 1][j]];
                cc[i][j] = cc[i - 1][j] + cc[i - 1][p[i - 1][j]];
            }
        }

        long maxSum = 0;
        for (int i = 0; i < n; ++i) {
            long sum = i;
            int cur = i;
            for (int h = MAX_H - 1; h >= 0; --h) {
                if ((k & (1l << h)) > 0) {
                    sum += cc[h][cur];
                    cur = p[h][cur];
                }
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}