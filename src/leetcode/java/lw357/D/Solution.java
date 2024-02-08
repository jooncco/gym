package leetcode.java.lw357.D;
// https://leetcode.com/contest/weekly-contest-357/problems/maximum-elegance-of-a-k-length-subsequence/

import java.util.*;

/**
 * Greedy
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        Arrays.sort(items, (a, b) -> b[0] - a[0]);

        long profitSum = 0;
        Map<Integer, Integer> categories = new HashMap<>();
        PriorityQueue<int[]> spares = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; ++i) {
            int profit = items[i][0], category = items[i][1];
            profitSum += profit;
            categories.put(category, categories.getOrDefault(category, 0) + 1);
            if (categories.get(category) > 1)
                spares.add(items[i]);
        }

        long distinctCategories = categories.size();
        long ans = profitSum + distinctCategories * distinctCategories;
        for (int i = k; i < n; ++i) {
            int profit = items[i][0], category = items[i][1];
            if (categories.containsKey(category))
                continue;
            if (spares.isEmpty())
                break;
            int[] minSpare = spares.poll();
            profitSum -= minSpare[0];
            profitSum += profit;
            categories.put(category, 1);
            ++distinctCategories;
            ans = Math.max(ans, profitSum + distinctCategories * distinctCategories);
        }
        return ans;
    }
}