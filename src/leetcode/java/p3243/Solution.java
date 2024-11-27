package leetcode.java.p3243;
// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/

import java.util.*;

/**
 * DP, DFS
 * Time: O(nQ)
 * Space: O(n)
 */
public class Solution {
    Map<Integer, Set<Integer>> adj= new HashMap<>();
    int[] dist;
    
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // init
        for (int i=0; i < n; ++i) {
            adj.put(i, new HashSet<>());
            if (i > 0) adj.get(i).add(i-1);
        }
        dist= new int[n];
        for (int i=0; i < n; ++i) {
            dist[i]= n-1-i;
        }

        // run dfs
        int[] ans= new int[queries.length];
        int idx= 0;
        for (int[] query : queries) {
            adj.get(query[1]).add(query[0]);
            dist[query[0]]= Math.min(dist[query[0]], dist[query[1]]+1);
            dfs(query[0]);
            ans[idx++]= dist[0];
        }
        return ans;
    }

    private void dfs(int here) {
        for (int there : adj.get(here)) {
            // Update distances that's shortened
            if (dist[there] > dist[here] + 1) {
                dist[there]= dist[here]+1;
                dfs(there);
            }
        }
    }
}