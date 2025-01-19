package leetcode.java.lw-362. C;
// https://leetcode.com/contest/weekly-contest-362/problems/minimum-moves-to-spread-stones-over-grid/

/**
 * DFS
 * | Time: O(9!)
 * | Space: O(9!)
 */
public class Solution {
    public int minimumMoves(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r == 3)
            return 0;
        if (c == 3)
            return dfs(grid, r + 1, 0);

        int ret = 1000;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (grid[i][j] > 0) {
                    --grid[i][j];
                    ret = Math.min(ret, Math.abs(r - i) + Math.abs(c - j) + dfs(grid, r, c + 1));
                    ++grid[i][j];
                }
            }
        }
        return ret;
    }
}