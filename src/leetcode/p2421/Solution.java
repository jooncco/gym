package leetcode.p2421;
// https://leetcode.com/problems/number-of-good-paths/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n= vals.length;
        Map<Integer, Set<Integer>> adj= new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], set -> new HashSet<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], set -> new HashSet<>()).add(edge[0]);
        }
        Map<Integer, Set<Integer>> valToNodes= new TreeMap<>();
        for (int i=0; i < n; ++i) {
            valToNodes.computeIfAbsent(vals[i], set -> new HashSet<>()).add(i);
        }

        int ans= 0;
        DisjointSet dj= new DisjointSet(n);
        for (int val : valToNodes.keySet()) {
            // union
            for (int here : valToNodes.get(val)) {
                if (!adj.containsKey(here)) continue;
                for (int there : adj.get(here)) {
                    if (vals[here] >= vals[there]) {
                        dj.union(here, there);
                    }
                }
            }
            // compute
            Map<Integer, Integer> groupSizes= new HashMap<>();
            for (int here : valToNodes.get(val)) {
                groupSizes.put(dj.find(here), groupSizes.getOrDefault(dj.find(here), 0) + 1);
            }
            for (int groupSize : groupSizes.values()) {
                ans += groupSize*(groupSize+1)/2;
            }
        }
        return ans;
    }

    private class DisjointSet {
        private int[] group;

        DisjointSet(int n) {
            group= new int[n];
            for (int i=0; i < n; ++i) {
                group[i]= i;
            }
        }

        int find(int a) {
            if (group[a] == a) return a;
            return group[a]= find(group[a]);
        }

        void union(int a, int b) {
            int groupA= find(a), groupB= find(b);
            if (groupA == groupB) return;
            group[groupB]= groupA;
        }
    }
}