package leetcode.java.p63;
// https://leetcode.com/problems/unique-paths-ii/

public class Solution {
    private int m, n, mem[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        mem = new int[m][n];

        dp(obstacleGrid);
        return mem[m - 1][n - 1];
    }

    private void dp(int[][] obstacleGrid) {
        for (int c = 0; c < n; ++c) {
            if (obstacleGrid[0][c] == 1)
                break;
            mem[0][c] = 1;
        }
        for (int r = 0; r < m; ++r) {
            if (obstacleGrid[r][0] == 1)
                break;
            mem[r][0] = 1;
        }

        for (int r = 1; r < m; ++r) {
            for (int c = 1; c < n; ++c) {
                if (obstacleGrid[r][c] == 1)
                    continue;
                mem[r][c] = mem[r - 1][c] + mem[r][c - 1];
            }
        }
    }
}