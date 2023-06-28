package leetcode.p1514;
// https://leetcode.com/problems/path-with-maximum-probability/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Dijkstra Algorithm
 * | Time: O (nE)
 * | Space: O (nE)
 */
public class Solution {
    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        Map<Integer, List<int[]>> adj= new HashMap<>();
        for (int i=0; i < n; ++i) adj.put(i, new ArrayList<>());
        for (int i=0; i < edges.length; ++i) {
            adj.get(edges[i][0]).add(new int[]{edges[i][1], i});
            adj.get(edges[i][1]).add(new int[]{edges[i][0], i});
        }
        double[] odds= new double[n];
        Queue<Node> queue= new LinkedList<>();
        queue.add(new Node(start, 1.0));
        while (!queue.isEmpty()) {
            Node cur= queue.poll();
            int node= cur.idx;
            double curOdds= cur.odds;
            if (odds[node] > curOdds) continue;

            for (int[] adjNode : adj.get(node)) {
                int there= adjNode[0];
                double edgeOdds= prob[adjNode[1]];
                if (odds[there] < curOdds*edgeOdds) {
                    odds[there]= curOdds*edgeOdds;
                    queue.add(new Node(there, odds[there]));
                }
            }
        }
        return odds[end];
    }

    private static class Node {
        int idx;
        double odds;

        Node(int idx, double odds) {
            this.idx= idx;
            this.odds= odds;
        }
    }
}