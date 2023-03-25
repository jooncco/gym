package leetcode.p2316;
// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

public class Solution {
    public long countPairs(int n, int[][] edges) {
        DisjointSet dj= new DisjointSet(n);
        long ans= 1L*n*(n-1)/2;
        if (edges.length == 0) return ans;
        for (int[] edge : edges) {
            int rankA= dj.getRank(edge[0]);
            int rankB= dj.getRank(edge[1]);
            boolean merged= dj.union(edge[0], edge[1]);
            if (merged) ans -= 1L*rankA*rankB;
        }
        return ans;
    }

    private static class DisjointSet {
        int size;
        int rank[];
        int group[];

        DisjointSet(int size) {
            this.size= size;
            rank= new int[size];
            for (int i=0; i < size; ++i) rank[i]= 1;
            group= new int[size];
            for (int i=0; i < size; ++i) group[i]= i;
        }

        int find(int idx) {
            if (group[idx] == idx) return idx;
            return group[idx]= find(group[idx]);
        }

        boolean union(int a, int b) {
            int groupA= find(a);
            int groupB= find(b);
            if (groupA == groupB) return false;
            group[groupB]= groupA;
            rank[groupA] += rank[groupB];
            return true;
        }

        int getRank(int idx) {
            return rank[find(idx)];
        }
    }
}
