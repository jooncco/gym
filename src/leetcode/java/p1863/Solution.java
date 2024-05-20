package leetcode.java.p1863;
// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

/**
 * DFS
 * Time: O(2^n)
 * Space: O(n)
 */
public class Solution {
    private int sum = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return sum;
    }

    private void dfs(int[] nums, int idx, int xor) {
        if (idx == nums.length) {
            sum += xor;
            return;
        }

        dfs(nums, idx + 1, xor);
        dfs(nums, idx + 1, xor ^ nums[idx]);
    }
}