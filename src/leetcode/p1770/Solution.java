package leetcode.p1770;
// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

public class Solution {
    int n,m;
    Integer[][] cache;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.n= nums.length;
        this.m= multipliers.length;
        cache= new Integer[m][m];
        return findMaximumScore(nums, multipliers, 0, 0);
    }

    private int findMaximumScore(final int[] nums, final int[] multipliers, int l, int idx) {
        if (idx == m) return 0;
        if (cache[l][idx] != null) return cache[l][idx];

        int r= n-1 - (idx-l);
        cache[l][idx]= Math.max(
                findMaximumScore(nums, multipliers, l+1, idx+1) + nums[l]*multipliers[idx],
                findMaximumScore(nums, multipliers, l, idx+1) + nums[r]*multipliers[idx]
        );
        return cache[l][idx];
    }
}
