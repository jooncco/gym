package leetcode.java.p2962;
// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

import java.util.*;

/**
 * Sliding Window
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        // find max num
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // a list of max num indices
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                maxIndices.add(i);
            }
        }
        // trivial?
        if (maxIndices.size() < k) {
            return 0;
        }
        // run sliding window on maxIndices list
        long subarrays = 0;
        int left = 0, right = k - 1;
        while (right < maxIndices.size()) {
            long leftCount = left == 0
                    ? maxIndices.get(left) + 1
                    : maxIndices.get(left) - maxIndices.get(left - 1);
            long rightCount = n - maxIndices.get(right);
            subarrays += leftCount * rightCount;
            left++;
            right++;
        }
        return subarrays;
    }
}