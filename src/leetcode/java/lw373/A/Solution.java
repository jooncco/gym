package leetcode.java.lw373.A;
// https://leetcode.com/contest/weekly-contest-373/problems/matrix-similarity-after-cyclic-shifts/

/**
 * Implementaion
 * | Time: O(mn)
 * | Space: O(1)
 */
public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        for (int r = 0; r < m; r += 2) {
            int[] row = new int[n];
            for (int c = k; c < n; ++c) {
                row[c - k] = mat[r][c];
            }
            for (int c = 0; c < k; ++c) {
                row[n - k + c] = mat[r][c];
            }
            for (int i = 0; i < n; ++i) {
                if (row[i] != mat[r][i])
                    return false;
            }
        }
        for (int r = 1; r < m; r += 2) {
            int[] row = new int[n];
            for (int c = 0; c < n - k; ++c) {
                row[c + k] = mat[r][c];
            }
            for (int c = n - k; c < n; ++c) {
                row[c - n + k] = mat[r][c];
            }
            for (int i = 0; i < n; ++i) {
                if (row[i] != mat[r][i])
                    return false;
            }
        }
        return true;
    }
}