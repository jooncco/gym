package leetcode.p1466;
// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minReorder(int n, int[][] connections) {
        // construct adjacent map
        Map<Integer, Set<int[]>> adj= new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], set -> new HashSet<>()).add(new int[]{connection[1], 1});
            adj.computeIfAbsent(connection[1], set -> new HashSet<>()).add(new int[]{connection[0], 0});
        }
        // run bfs
        int ans= 0;
        boolean visited[]= new boolean[n];
        visited[0]= true;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur= queue.poll();
            for (int[] adjNode : adj.get(cur)) {
                int there= adjNode[0];
                int cost= adjNode[1];
                if (visited[there]) continue;
                visited[there]= true;
                queue.add(there);
                ans += cost;
            }
        }
        return ans;
    }
}