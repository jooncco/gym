package leetcode.p787;
// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // reconstruct
        Map<Integer, Set<int[]>> adj= new HashMap<>(); // { from, { to, cost } }
        for (int[] flight : flights) {
            int from= flight[0], to= flight[1], price= flight[2];
            adj.computeIfAbsent(from, adjNodes -> new HashSet<>()).add(new int[]{to, price});
        }

        // bfs
        int[] minPrice= new int[n];
        for (int i=0; i < n; ++i) {
            minPrice[i]= Integer.MAX_VALUE;
        }
        minPrice[src]= 0;
        Queue<int[]> q= new LinkedList<>(); // {node, curPrice}
        q.add(new int[]{src, 0});
        for (int stops= 0; stops <= k; ++stops) {
            int size= q.size();
            while (size-- > 0) {
                int[] cur= q.poll();
                int here= cur[0], curPrice= cur[1];
                if (adj.get(here) == null) continue;
                for (int[] adjNode : adj.get(here)) {
                    int there= adjNode[0], cost= adjNode[1];
                    if (minPrice[there] <= curPrice + cost) continue;
                    minPrice[there]= curPrice + cost;
                    q.add(new int[]{there, curPrice + cost});
                }
            }
        }
        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }
}