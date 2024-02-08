package leetcode.java.p980;
// https://leetcode.com/problems/unique-paths-iii/

public class Solution {
    private int m, n, ans;
    private boolean[][] visited;
    private int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
    private int startX, startY, endX, endY, emptySquareCnt;

    public int uniquePathsIII(int[][] grid) {
        init(grid);
        dfs(grid, startY, startX, 0);
        return ans;
    }

    private void init(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        ans = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
                if (grid[i][j] == 0)
                    ++emptySquareCnt;
            }
        }
        visited[startX][startY] = true;
        System.out.println(emptySquareCnt);
    }

    private void dfs(int[][] grid, int y, int x, int cnt) {
        if (y == endY && x == endX) {
            if (cnt == emptySquareCnt)
                ++ans;
            return;
        }

        int ny, nx;
        for (int i = 0; i < 4; ++i) {
            ny = y + dy[i];
            nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                continue;
            if (visited[ny][nx])
                continue;
            if (grid[ny][nx] != 0)
                continue;
            visited[ny][nx] = true;
            dfs(grid, ny, nx, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}