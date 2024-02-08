package leetcode.java.p1519;
// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Map<Integer, Set<Integer>> adj;
    private int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // reconstruct
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, set -> new HashSet<>()).add(b);
            adj.computeIfAbsent(b, set -> new HashSet<>()).add(a);
        }

        // count
        ans = new int[n];
        countLabels(0, new boolean[n], labels);
        return ans;
    }

    private int[] countLabels(int here, boolean[] visited, String labels) {
        visited[here] = true;
        int[] counts = new int[26];
        ++counts[labels.charAt(here) - 'a'];
        for (int there : adj.get(here)) {
            if (visited[there])
                continue;
            int[] childCounts = countLabels(there, visited, labels);
            for (int i = 0; i < 26; ++i) {
                counts[i] += childCounts[i];
            }
        }
        ans[here] = counts[labels.charAt(here) - 'a'];
        return counts;
    }
}