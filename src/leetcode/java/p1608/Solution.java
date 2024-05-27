package leetcode.java.p1608;
// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

import java.util.*;

/**
 * Sortings
 * Time: O(nlogn)
 * Space: O(1)
 */
public class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (int x = 1; x <= nums.length; ++x) {
            while (i < nums.length && nums[i] < x)
                ++i;
            if (x == nums.length - i)
                return x;
        }
        return -1;
    }
}