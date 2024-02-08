package leetcode.java.p542;
// https://leetcode.com/problems/01-matrix/

import java.util.*;

/**
 * BFS
 * | Time: O (mn)
 * | Space: O (mn)
 */
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dis[i][j] = -1;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;
                    queue.add(new int[] { i, j, 0 });
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1], curDis = cur[2];
            int ny, nx;
            for (int i = 0; i < 4; ++i) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                    continue;
                if (dis[ny][nx] > -1)
                    continue;
                dis[ny][nx] = curDis + 1;
                queue.add(new int[] { ny, nx, curDis + 1 });
            }
        }
        return dis;
    }
}
