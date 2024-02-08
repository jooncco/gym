package leetcode.java.p2328;
// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (mn)
 * | Space: O (mn)
 */
public class Solution {
    private static final int MOD = (int) (1e9 + 7);
    private static final int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
    private int m, n;
    private int[][] cache;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        cache = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cache[i][j] = -1;
            }
        }
        int ans = 0;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                ans = (ans + count(grid, r, c)) % MOD;
            }
        }
        return ans;
    }

    private int count(int[][] grid, int r, int c) {
        if (cache[r][c] > -1)
            return cache[r][c];
        cache[r][c] = 1;
        int nr, nc;
        for (int i = 0; i < 4; ++i) {
            nr = r + dy[i];
            nc = c + dx[i];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                continue;
            if (grid[nr][nc] <= grid[r][c])
                continue;
            cache[r][c] = (cache[r][c] + count(grid, nr, nc)) % MOD;
        }
        return cache[r][c];
    }
}