package leetcode.p300;
// https://leetcode.com/problems/longest-increasing-subsequence/

/**
 * Dynamic Programming
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] cache= new int[n];
        for (int i=0; i < n; ++i) cache[i]= 1;

        int ans= 1;
        for (int i=1; i < n; ++i) {
            for (int j=0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    cache[i]= Math.max(cache[i], cache[j]+1);
                    ans= Math.max(ans, cache[i]);
                }
            }
        }
        return ans;
    }
}