package leetcode.java.p673;
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

/**
 * Dynamic Programming
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n], cnt = new int[n];
        len[0] = cnt[0] = 1;
        int maxLen = 0;
        for (int i = 1; i < n; ++i) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (len[i] < len[j] + 1)
                        cnt[i] = cnt[j];
                    if (len[i] == len[j] + 1)
                        cnt[i] += cnt[j];
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (len[i] == maxLen)
                ans += cnt[i];
        }
        return ans;
    }
}