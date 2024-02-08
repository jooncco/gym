package leetcode.java.p947;
// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }
        int ans = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (!used.contains(uf.find(i))) {
                ans += uf.getGroupSize(i) - 1;
                used.add(uf.find(i));
            }
        }
        return ans;
    }
}

class UnionFind {
    int[] group, size;

    UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; ++i)
            group[i] = i;
        size = new int[n];
        for (int i = 0; i < n; ++i)
            size[i] = 1;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;
        group[rootB] = group[rootA];
        size[rootA] += size[rootB];
    }

    int find(int idx) {
        if (group[idx] == idx)
            return idx;
        return group[idx] = find(group[idx]);
    }

    int getGroupSize(int idx) {
        return size[find(idx)];
    }
}