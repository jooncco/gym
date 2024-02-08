package leetcode.java.p62;
// https://leetcode.com/problems/unique-paths/

/**
 * DP
 * | Time: O (mn)
 * | Space: O (n)
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] cc = new int[n];
        for (int i = 0; i < n; ++i)
            cc[i] = 1;
        for (int j = 1; j < m; ++j) {
            for (int i = 1; i < n; ++i) {
                cc[i] += cc[i - 1];
            }
        }
        return cc[n - 1];
    }
}