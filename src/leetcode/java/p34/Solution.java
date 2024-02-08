package leetcode.java.p34;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/**
 * Binary Search
 * | Time: O(log(n))
 * | Space: O(1)
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };

        int l = binarySearch(nums, target);
        if (nums[l] != target)
            return new int[] { -1, -1 };
        int r = binarySearch(nums, target + 1);
        if (nums[r] != target)
            --r;
        return new int[] { l, r };
    }

    private static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}