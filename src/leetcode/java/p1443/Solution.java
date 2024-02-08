package leetcode.java.p1443;
// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Map<Integer, Set<Integer>> adj = new HashMap<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // reconstruct
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, set -> new HashSet<>()).add(b);
            adj.computeIfAbsent(b, set -> new HashSet<>()).add(a);
        }

        // compute
        return minTime(0, 0, new boolean[n], hasApple);
    }

    private int minTime(int here, int level, boolean[] visited, List<Boolean> hasApple) {
        visited[here] = true;
        int onlyHere = hasApple.get(here) ? level * 2 : 0;
        int children = 0;
        for (int adjVertex : adj.get(here)) {
            if (visited[adjVertex])
                continue; // parent
            int child = minTime(adjVertex, level + 1, visited, hasApple);
            if (child > 0) {
                children += child - level * 2;
            }
        }
        return children > 0 ? children + level * 2 : onlyHere;
    }
}