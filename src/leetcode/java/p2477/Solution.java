package leetcode.java.p2477;
// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private long ans, seats;
    private boolean[] visited;
    private Map<Integer, Set<Integer>> adj;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        visited = new boolean[n];
        adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], adjNodes -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], adjNodes -> new HashSet<>()).add(road[0]);
        }
        visited[0] = true;
        ans = 0;
        this.seats = seats;
        dfs(0);
        return ans;
    }

    private long dfs(int cur) {
        if (adj.get(cur) == null)
            return 0;
        long cnt = 1;
        for (int there : adj.get(cur)) {
            if (visited[there])
                continue;
            visited[there] = true;
            cnt += dfs(there);
        }
        if (cur > 0)
            ans += (cnt + seats - 1) / seats;
        return cnt;
    }
}