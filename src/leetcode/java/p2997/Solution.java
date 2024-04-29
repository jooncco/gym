package leetcode.java.p2997;
// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/

/**
 * Bitmask
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            if ((k & (1 << i)) != (bitmask & (1 << i))) {
                ++ans;
            }
        }
        return ans;
    }
}