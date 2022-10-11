package leetcode.p334;
// https://leetcode.com/problems/increasing-triplet-subsequence/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n= nums.length;
        if (n < 3) return false;

        int firstMin= nums[0], secondMin= Integer.MAX_VALUE;
        int idx= 0;
        while (++idx < n) {
            if (nums[idx] > secondMin) return true;
            if (nums[idx] == secondMin) continue;

            if (nums[idx] > firstMin) {
                secondMin= Math.min(secondMin, nums[idx]);
            } else {
                firstMin= Math.min(firstMin, nums[idx]);
            }
        }
        return false;
    }
}