package leetcode.java.p1493;
// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

/**
 * Sliding Window
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int zeros = nums[0] == 1 ? 0 : 1;
        int zeroIdx = nums[0] == 0 ? 0 : -1;
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == 0) {
                if (zeros == 1) {
                    l = zeroIdx + 1;
                } else {
                    zeros = 1;
                }
                zeroIdx = i;
            }
            ans = Math.max(ans, i - l);
        }
        return ans;
    }
}