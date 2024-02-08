package leetcode.java.p198;
// https://leetcode.com/problems/house-robber/

/**
 * DP (Bottom Up)
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] cc = new int[n + 1];
        cc[1] = nums[0];
        for (int i = 2; i <= n; ++i) {
            cc[i] = Math.max(cc[i - 1], cc[i - 2] + nums[i - 1]);
        }
        return cc[n];
    }
}