package leetcode.java.p2870;
// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/

import java.util.*;

/**
 * Greedy
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                if (cnt == 1)
                    return -1;
                ans += (cnt + 2) / 3;
                cnt = 1;
            } else {
                ++cnt;
            }
        }
        return cnt == 1 ? -1 : ans + (cnt + 2) / 3;
    }
}