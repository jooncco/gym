package leetcode.java.p70;
// https://leetcode.com/problems/climbing-stairs/

/**
 * DP (Bottom Up)
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int climbStairs(int n) {
        int[] cc = new int[n + 1];
        cc[0] = cc[1] = 1;
        for (int i = 2; i <= n; ++i) {
            cc[i] = cc[i - 1] + cc[i - 2];
        }
        return cc[n];
    }
}