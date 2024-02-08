package leetcode.java.p200;
// https://leetcode.com/problems/number-of-islands/

public class Solution {
    private final int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
    private int m, n, cnt = 0;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ++cnt;
                    markIslandAsVisited(grid, visited, i, j);
                }
            }
        }
        return cnt;
    }

    private void markIslandAsVisited(char[][] grid, boolean[][] visited, final int r, final int c) {
        int y = r, x = c;
        int ny, nx;
        for (int i = 0; i < dy.length; ++i) {
            ny = y + dy[i];
            nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                continue;
            if (grid[ny][nx] == '0' || visited[ny][nx])
                continue;
            visited[ny][nx] = true;
            markIslandAsVisited(grid, visited, ny, nx);
        }
    }
}