package leetcode.p1129;
// https://leetcode.com/problems/shortest-path-with-alternating-colors/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, Set<Integer>> adjRed= new HashMap<>();
        for (int[] edge : redEdges) {
            adjRed.computeIfAbsent(edge[0], nodes -> new HashSet<>()).add(edge[1]);
        }
        Map<Integer, Set<Integer>> adjBlue= new HashMap<>();
        for (int[] edge : blueEdges) {
            adjBlue.computeIfAbsent(edge[0], nodes -> new HashSet<>()).add(edge[1]);
        }
        // bfs
        int[][] minDist= new int[n][2];
        for (int i=1; i < n; ++i) minDist[i][0]= minDist[i][1]= Integer.MAX_VALUE;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] cur= queue.poll();
            int curNode= cur[0], curColor= cur[1];
            int nextColor= curColor == 1 ? 0 : 1;
            Set<Integer> adjNodes= curColor == 0 ? adjRed.get(curNode) : adjBlue.get(curNode);
            if (adjNodes == null) continue;
            for (int adjNode : adjNodes) {
                if (minDist[adjNode][nextColor] > minDist[curNode][curColor]+1) {
                    minDist[adjNode][nextColor]= minDist[curNode][curColor]+1;
                    queue.add(new int[]{adjNode, nextColor});
                }
            }
        }
        int[] ans= new int[n];
        for (int i=0; i < n; ++i) {
            if (minDist[i][0] == minDist[i][1] && minDist[i][0] == Integer.MAX_VALUE) {
                ans[i]= -1;
            }
            else {
                ans[i]= Math.min(minDist[i][0], minDist[i][1]);
            }
        }
        return ans;
    }
}