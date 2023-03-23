package leetcode.p1319;
// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet dj= new DisjointSet(n);
        Set<Integer> distinctGroups= new HashSet<>();
        int spareCables= 0;
        for (int[] connection : connections) {
            boolean isSameGroup= dj.union(connection[0], connection[1]);
            if (!isSameGroup) ++spareCables;
        }
        for (int group : dj.getGroup()) {
            distinctGroups.add(dj.find(group));
        }
        if (distinctGroups.size()-1 > spareCables) return -1;
        else return distinctGroups.size()-1;
    }

    private static class DisjointSet {
        int[] group;

        DisjointSet(int size) {
            group= new int[size];
            for (int i=0; i < size; ++i) group[i]= i;
        }

        int find(int idx) {
            if (group[idx] == idx) return idx;
            return group[idx]= find(group[idx]);
        }

        boolean union(int a, int b) {
            int aIdx= find(a);
            int bIdx= find(b);
            group[aIdx]= bIdx;
            return aIdx != bIdx;
        }

        int[] getGroup() {
            return group;
        }
    }
}