package leetcode.java.p797;
// https://leetcode.com/problems/all-paths-from-source-to-target/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int n;
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        List<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, path, 0);
        return ans;
    }

    void dfs(int[][] graph, List<Integer> path, int here) {
        if (here == n - 1) {
            ans.add(path);
            return;
        }

        List<Integer> newPath = (new LinkedList<>(path));
        newPath.add(here);
        for (int there : graph[here]) {
            dfs(graph, newPath, there);
        }
    }
}