package leetcode.java.p1706;
// https://leetcode.com/problems/where-will-the-ball-fall/

public class Solution {
    private int m, n;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] pos = new int[n];
        for (int i = 0; i < n; ++i)
            pos[i] = i;
        for (int r = 0; r < m; ++r) {
            for (int i = 0; i < n; ++i) {
                if (pos[i] == -1)
                    continue;

                if (goesLeft(grid, r, pos[i]))
                    --pos[i];
                else if (goesRight(grid, r, pos[i]))
                    ++pos[i];
                else
                    pos[i] = -1;
            }
        }
        return pos;
    }

    private boolean goesLeft(int[][] grid, int r, int c) {
        return c > 0 && grid[r][c - 1] == -1 && grid[r][c] == -1;
    }

    private boolean goesRight(int[][] grid, int r, int c) {
        return c < n - 1 && grid[r][c] == 1 && grid[r][c + 1] == 1;
    }
}
