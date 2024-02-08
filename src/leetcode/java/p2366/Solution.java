package leetcode.java.p2366;
// https://leetcode.com/problems/minimum-replacements-to-sort-the-array/

/**
 * Greedy, Number Theory
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = n - 1; i > 0; --i) {
            if (nums[i - 1] > nums[i]) {
                ans += nums[i - 1] / nums[i];
                if (nums[i - 1] % nums[i] == 0)
                    --ans;
                nums[i - 1] = nums[i - 1] / ((nums[i - 1] + nums[i] - 1) / nums[i]);
            }
        }
        return ans;
    }
}