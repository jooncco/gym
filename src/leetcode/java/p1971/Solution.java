package leetcode.java.p1971;
// https://leetcode.com/problems/find-if-path-exists-in-graph/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // reconstruct
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, key -> new LinkedList<>()).add(b);
            graph.computeIfAbsent(b, key -> new LinkedList<>()).add(a);
        }

        // simple BFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int here = queue.poll();
            visited[here] = true;
            if (!graph.containsKey(here))
                continue;
            for (int there : graph.get(here)) {
                if (visited[there])
                    continue;
                queue.add(there);
            }
        }
        return visited[destination];
    }
}
