package leetcode.java.p52;
// https://leetcode.com/problems/n-queens-ii/

public class Solution {
    private int n;

    public int totalNQueens(int n) {
        this.n = n;
        boolean[][] grid = new boolean[n][n];
        return findCount(grid, 0);
    }

    private int findCount(boolean[][] grid, int r) {
        if (r == n)
            return 1;

        int ans = 0;
        for (int c = 0; c < n; ++c) {
            if (canPut(grid, r, c)) {
                grid[r][c] = true;
                ans += findCount(grid, r + 1);
                grid[r][c] = false;
            }
        }
        return ans;
    }

    private boolean canPut(final boolean[][] grid, final int r, final int c) {
        int i, j;
        i = r - 1;
        while (i >= 0) {
            if (grid[i][c])
                return false;
            --i;
        }
        i = r - 1;
        j = c - 1;
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            --i;
            --j;
        }
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < n) {
            if (grid[i][j])
                return false;
            --i;
            ++j;
        }
        return true;
    }
}
