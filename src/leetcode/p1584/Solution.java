package leetcode.p1584;
// https://leetcode.com/problems/min-cost-to-connect-all-points/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    class UnionFind {
        public int group[], rank[];

        public UnionFind(int size) {
            group= new int[size];
            rank= new int[size];
            for (int i=0; i < size; ++i) group[i]= i;
        }

        public int find(int node) {
            if (group[node] != node) {
                group[node]= find(group[node]);
            }

            return group[node];
        }

        public boolean union(int node1, int node2) {
            int group1= find(node1);
            int group2= find(node2);

            // already in the same group
            if (group1 == group2) return false;

            if (rank[group1] > rank[group2]) {
                group[group2]= group1;
            }
            else if (rank[group1] < rank[group2]) {
                group[group1]= group2;
            }
            else {
                group[group1]= group2;
                rank[group2]++;
            }
            return true;
        }
    }

    private UnionFind uf;
    private List<int[]> allEdges= new ArrayList<>();

    public int minCostConnectPoints(int[][] points) {

        int n= points.length;
        uf= new UnionFind(n);
        for (int node1=0; node1 < n-1; ++node1) {
            for (int node2=node1+1; node2 < n; ++node2) {
                int weight= Math.abs(points[node1][0]-points[node2][0])
                        + Math.abs(points[node1][1]-points[node2][1]);

                int curEdge[]= { weight, node1, node2 };
                allEdges.add(curEdge);
            }
        }
        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0],b[0]));

        int minCost= 0, connectedCount= 0;
        for (int i=0; i < allEdges.size() && connectedCount < n-1; ++i) {
            int weight= allEdges.get(i)[0];
            int node1= allEdges.get(i)[1];
            int node2= allEdges.get(i)[2];
            if (uf.union(node1, node2)) {
                minCost += weight;
                ++connectedCount;
            }
        }
        return minCost;
    }
}