package leetcode.java.p287;
// https://leetcode.com/problems/find-the-duplicate-number/

/**
 * Math (Pigeonhole principle), Bitmask
 * Time: O(nlog(nums[i]))
 * Space: O(20)
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        // Compute bit count limits
        int n = nums.length - 1;
        int[] bitCountLimit = new int[20];
        for (int i = 1; i <= n; ++i) {
            for (int idx = 0; idx < 20; ++idx) {
                if (((1 << idx) & i) > 0) {
                    bitCountLimit[idx]++;
                }
            }
        }

        // Compute bit counts
        int[] bitCount = new int[20];
        for (int num : nums) {
            for (int idx = 0; idx < 20; ++idx) {
                if (((1 << idx) & num) > 0) {
                    bitCount[idx]++;
                }
            }
        }

        // Find the duplicate
        int duplicateNum = 0;
        for (int i = 0; i < 20; ++i) {
            if (bitCount[i] > bitCountLimit[i]) {
                duplicateNum += (1 << i);
            }
        }
        return duplicateNum;
    }
}