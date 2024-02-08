package leetcode.java.p1631;
// https://leetcode.com/problems/path-with-minimum-effort/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private int dir[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int y = p[0], x = p[1];
            if (y == m - 1 && x == n - 1)
                break;

            for (int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if (ny < 0 || ny >= m || nx < 0 || nx >= n)
                    continue;
                int alt = Math.max(p[2], Math.abs(heights[y][x] - heights[ny][nx]));
                if (alt < dist[ny][nx]) {
                    pq.add(new int[] { ny, nx, dist[ny][nx] = alt });
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}