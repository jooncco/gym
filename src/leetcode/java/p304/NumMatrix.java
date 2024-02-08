package leetcode.java.p304;
// https://leetcode.com/problems/range-sum-query-2d-immutable/

public class NumMatrix {

    private int n, m, matrix[][], cummSum[][];

    public NumMatrix(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.matrix = new int[n][m];
        this.cummSum = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                this.matrix[i][j] = matrix[i][j];
                this.cummSum[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                this.cummSum[i][j] += this.cummSum[i][j - 1];
            }
        }
        for (int j = 0; j < m; ++j) {
            for (int i = 1; i < n; ++i) {
                this.cummSum[i][j] += this.cummSum[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = cummSum[row2][col2];
        if (row1 > 0)
            ans -= cummSum[row1 - 1][col2];
        if (col1 > 0)
            ans -= cummSum[row2][col1 - 1];
        if (row1 > 0 && col1 > 0)
            ans += cummSum[row1 - 1][col1 - 1];
        return ans;
    }
}