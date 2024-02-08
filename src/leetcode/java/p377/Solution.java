package leetcode.java.p377;
// https://leetcode.com/problems/combination-sum-iv/

import java.util.Arrays;

public class Solution {
    private int n;
    private int[] cache;

    public int combinationSum4(int[] nums, int target) {
        this.n = nums.length;
        this.cache = new int[target + 1];
        Arrays.fill(cache, -1);
        return dfs(nums, target);
    }

    private int dfs(final int[] nums, int target) {
        if (target == 0)
            return 1;
        if (cache[target] >= 0)
            return cache[target];

        cache[target] = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= target) {
                cache[target] += dfs(nums, target - nums[i]);
            }
        }
        return cache[target];
    }
}