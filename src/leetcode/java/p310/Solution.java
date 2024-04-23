package leetcode.java.p310;

import java.util.*;

/**
 * BFS
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int nodeCount = n;
        if (n == 1)
            return List.of(0);

        // Init graph
        int[] edgeCount = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            edgeCount[edge[0]]++;
            edgeCount[edge[1]]++;
            adj.computeIfAbsent(edge[0], x -> new HashSet<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], x -> new HashSet<>()).add(edge[0]);
        }

        // Remove leaves until 2 nodes left (BFS)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (edgeCount[i] == 1) {
                queue.add(i);
            }
        }
        while (nodeCount > 2) {
            int size = queue.size();
            nodeCount -= size;
            while (size-- > 0) {
                int here = queue.poll();
                for (int there : adj.get(here)) {
                    if (--edgeCount[there] == 1) {
                        queue.add(there);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }
}