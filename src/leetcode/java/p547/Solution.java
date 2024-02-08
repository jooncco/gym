package leetcode.java.p547;
// https://leetcode.com/problems/number-of-provinces/

/**
 * Disjoint Set
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        int ans = n;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    if (ds.union(i, j))
                        --ans;
                }
            }
        }
        return ans;
    }

    private static class DisjointSet {
        final int[] group;

        DisjointSet(int n) {
            group = new int[n];
            for (int i = 0; i < n; ++i)
                group[i] = i;
        }

        int find(int a) {
            if (group[a] == a)
                return a;
            return group[a] = find(group[a]);
        }

        boolean union(int a, int b) {
            int groupA = find(a);
            int groupB = find(b);
            if (groupA == groupB)
                return false;
            group[groupB] = groupA;
            return true;
        }
    }
}