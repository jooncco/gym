package leetcode.p1658;
// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

/**
 * Sliding Window
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int minOperations(int[] nums, int x) {
        int n= nums.length;
        int sum= 0;
        for (int num : nums) sum += num;
        if (sum < x) return -1;
        
        int ans= Integer.MAX_VALUE;
        int windowSum= 0, target= sum-x, l= 0;
        for (int i= 0; i < n; ++i) {
            windowSum += nums[i];
            while (target < windowSum && l <= i) {
                windowSum -= nums[l++];
            }
            if (target == windowSum) {
                ans= Math.min(ans, l+n-1-i);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}