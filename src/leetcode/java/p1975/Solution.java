package leetcode.java.p1975;
// https://leetcode.com/problems/maximum-matrix-sum/

/**
 * Greedy
 * Time: (n^2)
 * Space: O(1)
 */
public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int negCnt = 0, minAbsVal = Integer.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                minAbsVal = Math.min(minAbsVal, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0)
                    ++negCnt;
                ans += Math.abs(matrix[i][j]);
            }
        }
        if (negCnt % 2 == 1)
            ans -= minAbsVal * 2;
        return ans;
    }
}
