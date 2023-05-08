package leetcode.p1572;
// https://leetcode.com/problems/matrix-diagonal-sum/

/**
 * Math
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int diagonalSum(int[][] mat) {
        final int n= mat.length;
        int sum= 0;
        int l= 0, r= n-1;
        for (int[] num : mat) {
            if (l == r) sum -= num[l];
            sum += num[l] + num[r];
            ++l;
            --r;
        }
        return sum;
    }
}