package leetcode.java.p2742;
// https://leetcode.com/problems/painting-the-walls/

/**
 * DP
 * | Time: O(n^2)
 * | Space: O(n^2)
 */
public class Solution {
    private static final int INF = 987654321;
    private int[][] cc;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        cc = new int[n][n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                cc[i][j] = -1;
            }
        }
        return minCost(cost, time, n, 0, n);
    }

    private int minCost(int[] cost, int[] time, int n, int idx, int rem) {
        if (idx == n) {
            return rem <= 0 ? 0 : INF;
        }
        if (cc[idx][rem] > -1)
            return cc[idx][rem];

        cc[idx][rem] = Math.min(
                cost[idx] + minCost(cost, time, n, idx + 1, Math.max(0, rem - time[idx] - 1)), // use it
                minCost(cost, time, n, idx + 1, rem)); // don't
        return cc[idx][rem];
    }
}