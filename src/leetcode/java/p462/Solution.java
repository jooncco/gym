package leetcode.java.p462;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n / 2], ans = 0;
        for (final int num : nums) {
            ans += Math.abs(num - median);
        }
        return ans;
    }
}