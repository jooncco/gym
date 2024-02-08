package leetcode.java.p743;
// https://leetcode.com/problems/network-delay-time/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    List<List<Edge>> edges;
    int time[];

    public int networkDelayTime(int[][] times, int n, int k) {
        edges = new ArrayList<>();
        time = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            edges.add(new ArrayList<>());
            time[i] = -1;
        }
        for (int[] time : times) {
            int target = time[1], weight = time[2];
            edges.get(time[0]).add(new Edge(target, weight));
        }

        // run dijkstra
        PriorityQueue<PQNode> pq = new PriorityQueue<>();
        time[k] = 0;
        pq.add(new PQNode(k, 0));
        while (!pq.isEmpty()) {
            PQNode cur = pq.poll();
            int curNode = cur.node;
            int curTime = cur.time;
            if (curTime > time[curNode])
                continue;

            for (Edge edge : edges.get(curNode)) {
                if (time[edge.target] == -1 || time[edge.target] > curTime + edge.weight) {
                    time[edge.target] = curTime + edge.weight;
                    pq.add(new PQNode(edge.target, curTime + edge.weight));
                }
            }
        }

        boolean visitedAll = true;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            if (time[i] == -1)
                visitedAll = false;
            ans = Math.max(ans, time[i]);
        }
        return visitedAll ? ans : -1;
    }
}

class PQNode implements Comparable<PQNode> {
    int node, time;

    public PQNode(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(PQNode o) {
        return this.time - o.time;
    }
}

class Edge {
    int target, weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}