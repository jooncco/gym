package leetcode.java.p834;
// https://leetcode.com/problems/sum-of-distances-in-tree/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    List<Set<Integer>> adj;
    int[] size, distSum;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // reconstruct
        adj = new ArrayList<>(n);
        distSum = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i)
            adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // 1. update size, distSum
        // size: # of nodes in subtree
        // distSum: sum(distance from root)
        boolean[] visited = new boolean[n];
        dfs1(visited, 0, 0);

        // 2. update distSum
        // distSum: sum(distance from this node)
        visited = new boolean[n];
        dfs2(n, visited, -1, 0);

        return distSum;
    }

    private void dfs1(boolean[] visited, int here, int dist) {
        visited[here] = true;
        size[here] = 1;
        distSum[here] = dist;
        for (int there : adj.get(here)) {
            // skip parent
            if (!visited[there]) {
                // post-order
                dfs1(visited, there, dist + 1);
                size[here] += size[there];
                distSum[here] += distSum[there];
            }
        }
    }

    private void dfs2(int n, boolean[] visited, int prev, int here) {
        visited[here] = true;
        // pre-order
        if (prev > -1)
            distSum[here] = distSum[prev] - size[here] + n - size[here];
        for (int there : adj.get(here)) {
            // skip parent
            if (!visited[there]) {
                dfs2(n, visited, here, there);
            }
        }
    }
}