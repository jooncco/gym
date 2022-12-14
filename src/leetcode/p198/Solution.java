package leetcode.p198;
// https://leetcode.com/problems/house-robber/

public class Solution {
    public int rob(int[] nums) {
        return robBottomUpOptimal(nums);
    }

    // Top-down DP with O(n) space
    private int robTopDown(int[] nums, int[] maxProfit, int idx) {
        if (idx < 0) return 0;
        if (maxProfit[idx] > -1) return maxProfit[idx];
        return maxProfit[idx]= Math.max(robTopDown(nums, maxProfit, idx-2) + nums[idx], robTopDown(nums, maxProfit, idx-1));
    }

    // Bottom-up DP with O(n) space
    private int robBottomUp(int[] nums) {
        int[] maxProfit= new int[nums.length+1];
        maxProfit[0]= 0;
        maxProfit[1]= nums[0];
        for (int i=1; i < nums.length; ++i) {
            maxProfit[i+1]= Math.max(maxProfit[i-1] + nums[i], maxProfit[i]);
        }
        return maxProfit[nums.length];
    }

    // Bottom-up DP with O(1) space
    private int robBottomUpOptimal(int[] nums) {
        int prevPrev= 0, prev= nums[0];
        for (int i=1; i < nums.length; ++i) {
            int cur= Math.max(prevPrev + nums[i], prev);
            prevPrev= prev;
            prev= cur;
        }
        return prev;
    }
}