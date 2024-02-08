package leetcode.java.p2448;
// https://leetcode.com/problems/minimum-cost-to-make-array-equal/

/**
 * Binary Search
 * | Time: O (n log(max(nums)-min(nums)))
 * | Space: O (1)
 */
public class Solution {
    public long minCost(int[] nums, int[] cost) {
        int l = 1000_001, r = 0;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            long currCost = cost(nums, cost, m);
            if (cost(nums, cost, m - 1) < currCost)
                r = m;
            else
                l = m + 1;
        }
        return Math.min(cost(nums, cost, l), cost(nums, cost, l - 1));
    }

    private long cost(int[] nums, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < nums.length; ++i) {
            long diff = Math.abs(nums[i] - target);
            total += diff * cost[i];
        }
        return total;
    }
}