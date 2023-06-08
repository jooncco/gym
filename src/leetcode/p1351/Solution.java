package leetcode.p1351;
// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

/**
 * Ad hoc
 * | Time: O (mn)
 * | Space: O (1)
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int ans= 0;
        for (int[] row : grid) {
            for (int num : row) {
                if (num < 0) ++ans;
            }
        }
        return ans;
    }
}