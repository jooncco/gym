package leetcode.java.p329;
// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class Solution {
    private int m, n;
    private int matrix[][], mem[][];
    private int d[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        mem = new int[m][n];

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, findMaxLength(i, j));
            }
        }
        return ans;
    }

    public int findMaxLength(final int y, final int x) {
        if (mem[y][x] > 0)
            return mem[y][x];

        for (int[] dif : d) {
            int ny = y + dif[0], nx = x + dif[1];
            if (ny >= 0 && ny < m && nx >= 0 && nx < n && matrix[ny][nx] > matrix[y][x]) {
                mem[y][x] = Math.max(mem[y][x], findMaxLength(ny, nx));
            }
        }
        return ++mem[y][x];
    }
}