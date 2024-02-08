package leetcode.java.p896;
// https://leetcode.com/problems/monotonic-array/

/**
 * Brute Force
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1)
            return true;
        int idx = 1;
        while (idx < nums.length && nums[idx] >= nums[idx - 1])
            ++idx;
        if (idx == nums.length)
            return true;
        idx = 1;
        while (idx < nums.length && nums[idx] <= nums[idx - 1])
            ++idx;
        if (idx == nums.length)
            return true;
        return false;
    }
}