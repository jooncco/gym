package leetcode.p576;
// https://leetcode.com/problems/out-of-boundary-paths/

/**
 * DP (Top Down)
 * | Time: O(mnM)
 * | Space: O(mnM)
 */
public class Solution {
    private int m, n;
    private int[][][] cc;

    public int findPaths(int m, int n, int M, int startRow, int startColumn) {
        this.m = m; this.n = n;
        cc = new int[m][n][M + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k <= M; ++k) {
                    cc[i][j][k] = -1;
                }
            }
        }
        return countWays(startRow, startColumn, M);
    }

    private int countWays(int r, int c, int moves) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return 1;
        if (cc[r][c][moves] != -1)
            return cc[r][c][moves];
        if (moves == 0)
            return 0;

        cc[r][c][moves] = 0;
        cc[r][c][moves] = _add(cc[r][c][moves], countWays(r - 1, c, moves - 1));
        cc[r][c][moves] = _add(cc[r][c][moves], countWays(r + 1, c, moves - 1));
        cc[r][c][moves] = _add(cc[r][c][moves], countWays(r, c - 1, moves - 1));
        cc[r][c][moves] = _add(cc[r][c][moves], countWays(r, c + 1, moves - 1));
        return cc[r][c][moves];
    }

    private static final int MOD = (int) 1e9 + 7;
    private static int _add(int a, int b) {
        return (int) ((a + 0L + b) % MOD);
    }
}