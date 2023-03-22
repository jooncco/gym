package leetcode.p2492;
// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minScore(int n, int[][] roads) {
        // construct adjacent map
        Map<Integer, Set<int[]>> adj= new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0],
                    set -> new HashSet<>()).add(new int[]{road[1], road[2]});
            adj.computeIfAbsent(road[1],
                    set -> new HashSet<>()).add(new int[]{road[0], road[2]});
        }

        // run bfs
        int ans= Integer.MAX_VALUE;
        boolean[] visited= new boolean[n+1];
        visited[1]= true;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur= queue.poll();
            for (int[] nodeAndDist : adj.get(cur)) {
                int there= nodeAndDist[0];
                int distance= nodeAndDist[1];
                ans= Math.min(ans, distance);
                if (visited[there]) continue;
                visited[there]= true;
                queue.add(there);
            }
        }
        return ans;
    }
}