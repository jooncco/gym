package leetcode.java.p931;
// https://leetcode.com/problems/minimum-falling-path-sum/

/**
 * DP (Bottom Up)
 * | Time: O(n^2)
 * | Space: O(1)
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int r = 1; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                int minVal = Integer.MAX_VALUE;
                if (c > 0)
                    minVal = Math.min(minVal, matrix[r - 1][c - 1] + matrix[r][c]);
                minVal = Math.min(minVal, matrix[r - 1][c] + matrix[r][c]);
                if (c < n - 1)
                    minVal = Math.min(minVal, matrix[r - 1][c + 1] + matrix[r][c]);
                matrix[r][c] = minVal;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; ++c)
            ans = Math.min(ans, matrix[n - 1][c]);
        return ans;
    }
}