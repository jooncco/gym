package leetcode.java.p645;
// https://leetcode.com/problems/set-mismatch/

import java.util.*;

/**
 * Sortings
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int missing = nums[0] != 1 ? 1 : -1, duplicate = -1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1])
                duplicate = nums[i];
            if (nums[i] - 2 == nums[i - 1])
                missing = nums[i] - 1;
        }
        if (missing == -1)
            missing = nums.length;
        return new int[] { duplicate, missing };
    }
}