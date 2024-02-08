package leetcode.java.p785;
// https://leetcode.com/problems/is-graph-bipartite/

/**
 * Union Find (Disjoint set)
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {

    class UnionFind {
        private int[] group, rank;

        public UnionFind(int n) {
            group = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i)
                group[i] = i;
        }

        public int find(int node) {
            if (group[node] != node) {
                group[node] = find(group[node]);
            }
            return group[node];
        }

        public void union(int node1, int node2) {
            int group1 = find(node1);
            int group2 = find(node2);

            if (rank[group1] > rank[group2]) {
                group[group2] = group1;
            } else if (rank[group2] > rank[group1]) {
                group[group1] = group2;
            } else {
                group[group1] = group2;
                rank[group2]++;
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);

        for (int node = 0; node < n; ++node) {
            int[] adjNodes = graph[node];
            for (int i = 0; i < adjNodes.length; ++i) {
                // this adjacent node already in same group?
                if (uf.find(node) == uf.find(adjNodes[i]))
                    return false;

                // union adjacent nodes into one group
                if (i > 0) {
                    uf.union(adjNodes[i - 1], adjNodes[i]);
                }
            }
        }
        return true;
    }
}