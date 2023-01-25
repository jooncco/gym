package leetcode.p2359;
// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/

public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n= edges.length;
        int[][] distance= new int[2][n];
        for (int i=0; i < 2; ++i) {
            for (int node= 0; node < n; ++node) {
                distance[i][node]= Integer.MAX_VALUE;
            }
        }
        dfs(edges, distance[0], node1, 0);
        dfs(edges, distance[1], node2, 0);
        int ans= -1, minDist= Integer.MAX_VALUE;
        for (int i=0; i < n; ++i) {
            if (Math.max(distance[0][i], distance[1][i]) < minDist) {
                minDist= Math.max(distance[0][i], distance[1][i]);
                ans= i;
            }
        }
        return ans;
    }

    private void dfs(int[] edges, int[] distance, int curIdx, int curDist) {
        distance[curIdx]= curDist;
        if (edges[curIdx] != -1 && distance[edges[curIdx]] == Integer.MAX_VALUE) {
            dfs(edges, distance, edges[curIdx], curDist+1);
        }
    }
}