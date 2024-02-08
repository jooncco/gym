package leetcode.java.p209;
// https://leetcode.com/problems/minimum-size-subarray-sum/

/**
 * Sliding Window
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target)
            return 1;
        int ans = Integer.MAX_VALUE, sum = nums[0], l = 0;
        for (int i = 1; i < nums.length; ++i) {
            sum += nums[i];
            while (l < i && sum - nums[l] >= target) {
                sum -= nums[l++];
            }
            if (sum >= target) {
                ans = Math.min(ans, i - l + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}