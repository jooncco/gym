package leetcode.java.p334;
// https://leetcode.com/problems/increasing-triplet-subsequence/

/**
 * DP
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int one= Integer.MAX_VALUE, two= Integer.MAX_VALUE;
        for (int num : nums) {
            if (one < num) {
                if (two < num) return true;
                two= num;
            } else {
                one= num;
            }
        }
        return false;
    }
}