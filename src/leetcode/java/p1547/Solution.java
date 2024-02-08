package leetcode.java.p1547;
// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming (Top-down)
 * | Time: O (cuts.length ^ 2)
 * | Space: O (cuts.length)
 */
public class Solution {
    private Map<String, Integer> cache;

    public int minCost(int n, int[] cuts) {
        cache = new HashMap<>();
        return findMinCost(cuts, 0, n);
    }

    private int findMinCost(int[] cuts, int l, int r) {
        String key = l + "," + r;
        if (cache.containsKey(key))
            return cache.get(key);

        int minCost = Integer.MAX_VALUE;
        for (int cut : cuts) {
            if (cut <= l || r <= cut)
                continue;
            minCost = Math.min(minCost, findMinCost(cuts, l, cut) + findMinCost(cuts, cut, r));
        }
        cache.put(key, minCost == Integer.MAX_VALUE ? 0 : minCost);
        return cache.get(key);
    }
}