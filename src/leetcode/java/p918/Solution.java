package leetcode.java.p918;
// https://leetcode.com/problems/maximum-sum-circular-subarray/

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int minSum, maxSum, totalSum, curMin, curMax;
        minSum = maxSum = totalSum = curMin = curMax = nums[0];
        for (int i = 1; i < n; ++i) {
            totalSum += nums[i];
            if (curMin + nums[i] > nums[i])
                curMin = nums[i];
            else
                curMin += nums[i];
            minSum = Math.min(minSum, curMin);
            if (curMax + nums[i] < nums[i])
                curMax = nums[i];
            else
                curMax += nums[i];
            maxSum = Math.max(maxSum, curMax);
        }
        return totalSum == minSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }
}