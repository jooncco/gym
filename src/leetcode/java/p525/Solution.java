package leetcode.java.p525;
// https://leetcode.com/problems/contiguous-array/

import java.util.*;

/**
 * DP (Botton-up), Prefix sum
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        // Keep track of the first index of each sum
        Map<Integer, Integer> firstIdxOfPrefixSum = new HashMap<>();
        firstIdxOfPrefixSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += (nums[i] == 0 ? -1 : 1);

            // Update maxLen if found the matching sum
            if (firstIdxOfPrefixSum.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - firstIdxOfPrefixSum.get(sum));
            }

            // Cache the first index of the sum
            if (!firstIdxOfPrefixSum.containsKey(sum)) {
                firstIdxOfPrefixSum.put(sum, i);
            }
        }
        return maxLen;
    }
}