package leetcode.java.p2009;
// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

import java.util.*;

/**
 * Sortings, Sliding Window
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = n - 1;
        int l = 0, dups = 0;
        for (int r = 1; r < n; ++r) {
            if (nums[r] == nums[r - 1])
                ++dups;
            else {
                while (nums[l] < nums[r] - n + 1) {
                    ++l;
                    if (l > 0 && nums[l] == nums[l - 1])
                        --dups;
                }
            }
            ans = Math.min(ans, n - (r - l + 1) + dups);
        }
        return ans;
    }
}