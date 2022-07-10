package leetcode.p746;

import java.util.Arrays;

public class Solution {
    private int n, cache[];

    public int minCostClimbingStairs(int[] cost) {
        this.n= cost.length;
        cache= new int[n+2];
        Arrays.fill(cache, -1);
        return Math.min(findMinCost(cost, n-1), findMinCost(cost, n-2));
    }

    private int findMinCost(final int[] cost, final int idx) {
        if (idx <= 1) return cost[idx];
        if (cache[idx] != -1) return cache[idx];

        int minCost= Math.min(findMinCost(cost, idx-1), findMinCost(cost, idx-2));
        cache[idx]= minCost + cost[idx];
        return cache[idx];
    }
}
