package leetcode.p1685;
// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

/**
 * Math
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n= nums.length;
        int[] ans= new int[n];
        for (int i=1; i < n; ++i) {
            ans[0] += nums[i]-nums[0];
        }
        for (int i=1; i < n; ++i) {
            ans[i]= ans[i-1];
            int diff= nums[i]-nums[i-1];
            ans[i] += Math.max(0, (i-1)*diff);
            ans[i] -= (n-1-i)*diff;
        }
        return ans;
    }
}