package leetcode.java.p300;
// https://leetcode.com/problems/longest-increasing-subsequence/

/**
 * Dynamic Programming
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] cc = new int[n];
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            cc[i] = 1;
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] > nums[i]) {
                    cc[i] = Math.max(cc[i], cc[j] + 1);
                }
            }
            ans = Math.max(ans, cc[i]);
        }
        return ans;
    }
}