package leetcode.java.p1162;
// https://leetcode.com/problems/as-far-from-land-as-possible/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDistance(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        final int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dist[i][j] = grid[i][j] == 1 ? 0 : -1;
                if (grid[i][j] == 1)
                    queue.add(new int[] { i, j });
            }
        }
        // bfs
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ny, nx;
            for (int i = 0; i < 4; ++i) {
                System.out.println(cur[0] + " / " + cur[1]);
                ny = cur[0] + dy[i];
                nx = cur[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                    continue;
                if (dist[ny][nx] > -1)
                    continue;
                dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
                queue.add(new int[] { ny, nx });
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dist[i][j]);
            }
        }
        return ans == 0 ? -1 : ans;
    }
}