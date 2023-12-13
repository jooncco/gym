package leetcode.p1582;
// https://leetcode.com/problems/special-positions-in-a-binary-matrix/

/**
 * Brute Force
 * | Time: O(mn)
 * | Space: O(1)
 */
public class Solution {
    public int numSpecial(int[][] mat) {
        int m= mat.length, n= mat[0].length;
        int[] row= new int[m], col= new int[n];
        for (int i= 0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (mat[i][j] == 1) {
                    ++row[i];
                    ++col[j];
                }
            }
        }
        int ans= 0;
        for (int i= 0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) ++ans;
            }
        }
        return ans;
    }
}