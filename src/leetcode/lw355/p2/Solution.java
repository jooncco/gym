package leetcode.lw355.p2;
// https://leetcode.com/contest/weekly-contest-355/problems/largest-element-in-an-array-after-merge-operations/

/**
 * Greedy
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public long maxArrayValue(int[] nums) {
        int n= nums.length;
        long cur= nums[n-1], ans= cur;
        for (int i=n-1; i > 0; --i) {
            if (cur >= nums[i-1]) {
                cur += nums[i-1];
            } else {
                cur= nums[i-1];
            }
            ans= Math.max(ans, cur);
        }
        return ans;
    }
}