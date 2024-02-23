package leetcode.java.p787;
// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.*;

/**
 * BFS
 * Time: O(nk)
 * Space: O(n)
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Init adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.putIfAbsent(flight[0], new ArrayList<>());
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] }); // {there, cost}
        }

        // Init minimum cost array
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        // Run BFS up to k stops
        Queue<int[]> queue = new LinkedList<>(); // {node, cost}
        queue.add(new int[] { src, 0 });
        for (int stops = 0; stops <= k; ++stops) {
            int size = queue.size();
            while (size-- > 0) {
                int[] here = queue.poll();
                if (adj.containsKey(here[0])) {
                    for (int[] there : adj.get(here[0])) {
                        int nextNode = there[0];
                        int nextCost = here[1] + there[1];
                        if (nextNode == dst) {
                            minCost[dst] = Math.min(minCost[dst], nextCost);
                            continue;
                        }
                        if (minCost[nextNode] <= nextCost) {
                            continue;
                        }

                        minCost[nextNode] = nextCost;
                        queue.add(new int[] { nextNode, nextCost });
                    }
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}