package leetcode.p2256;
// https://leetcode.com/problems/minimum-average-difference/

public class Solution {
    public int minimumAverageDifference(int[] nums) {
        long lSum= 0, rSum= 0;
        for (int num : nums) rSum += num;
        int n= nums.length, minIdx= 0;
        long minDiff= Long.MAX_VALUE;
        for (int i=0; i < n; ++i) {
            lSum += nums[i];
            rSum -= nums[i];
            long curDiff= i == n-1 ? lSum/n : Math.abs(lSum/(i+1) - rSum/(n-i-1));
            if (curDiff < minDiff) {
                minIdx= i;
                minDiff= curDiff;
            }
        }
        return minIdx;
    }
}