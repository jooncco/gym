package leetcode.java.p2924;
// https://leetcode.com/problems/find-champion-ii/

/**
 * Graph
 * Time: O(n + m)
 * Space: O(n)
 */
public class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            ++inDegree[edge[1]];
        }
        int champion= -1;
        for (int i=0; i < n; ++i) {
            if (inDegree[i] == 0) {
                if (champion != -1)
                    return -1;
                champion = i;
            }
        }
        return champion;
    }
}