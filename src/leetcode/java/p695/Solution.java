package leetcode.java.p695;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int m, n, numOfIslands = 0, ans = 0;
    private final int[] dy = { -1, 1, 0, 0 };
    private final int[] dx = { 0, 0, -1, 1 };
    private int[][] mark;
    private Map<Integer, Integer> cnt;

    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        mark = new int[m][n];
        cnt = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0 && mark[i][j] == 0) {
                    mark[i][j] = ++numOfIslands;
                    cnt.put(numOfIslands, 1);
                    ans = Math.max(ans, cnt.get(numOfIslands));
                    floodFill(grid, mark, i, j);
                }
            }
        }
        return ans;
    }

    private void floodFill(final int[][] grid, int[][] mark, int y, int x) {
        int ny, nx;
        for (int i = 0; i < 4; ++i) {
            ny = y + dy[i];
            nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                continue;
            if (grid[ny][nx] == 0)
                continue;
            if (mark[ny][nx] > 0)
                continue;
            mark[ny][nx] = mark[y][x];
            cnt.put(mark[ny][nx], cnt.get(mark[ny][nx]) + 1);
            ans = Math.max(ans, cnt.get(mark[ny][nx]));
            floodFill(grid, mark, ny, nx);
        }
    }
}
