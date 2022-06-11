package leetcode.p1658;
// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/


import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int n= nums.length;
        if (n == 1) return nums[0] == x ? 1 : -1;

        int target = Arrays.stream(nums).sum() - x;
        int windowSum= nums[0], l= 0;
        int minOp= Integer.MAX_VALUE;
        if (target == windowSum) minOp= n-1;
        for (int i=1; i < n; ++i) {
            windowSum += nums[i];
            while (target < windowSum && l <= i) windowSum -= nums[l++];
            if (target == windowSum) {
                minOp= Math.min( minOp, n-(i-l+1) );
            }
        }
        return minOp == Integer.MAX_VALUE ? -1 : minOp;
    }
}