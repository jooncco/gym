package leetcode.java.p2441;
// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

import java.util.*;

/**
 * Two Pointers
 * Time: O(n log(n))
 * Space: O(1)
 */
public class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] * nums[r] >= 0)
                break;
            if (-nums[l] == nums[r])
                return nums[r];
            if (-nums[l] > nums[r])
                ++l;
            else
                --r;
        }
        return -1;
    }
}