package leetcode.p1254;
// https://leetcode.com/problems/number-of-closed-islands/

public class Solution {
    private int m, n;
    private boolean[][] visited;

    public int closedIsland(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        visited= new boolean[m][n];
        int islands= 0;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    ++islands;
                    mark(grid, i, j, true);
                }
            }
        }
        for (int r=0; r < m; ++r) {
            if (grid[r][0] == 0 && visited[r][0]) {
                --islands;
                mark(grid, r, 0, false);
            }
            if (grid[r][n-1] == 0 && visited[r][n-1]) {
                --islands;
                mark(grid, r, n-1, false);
            }
        }
        for (int c=0; c < n; ++c) {
            if (grid[0][c] == 0 && visited[0][c]) {
                --islands;
                mark(grid, 0, c, false);
            }
            if (grid[m-1][c] == 0 && visited[m-1][c]) {
                --islands;
                mark(grid, m-1, c, false);
            }
        }
        return islands;
    }

    private void mark(int[][] grid, int r, int c, boolean visitedValue) {
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        visited[r][c]= visitedValue;
        if (r > 0 && visited[r-1][c] != visitedValue && grid[r-1][c] == 0) mark(grid, r-1, c, visitedValue);
        if (r < m-1 && visited[r+1][c] != visitedValue && grid[r+1][c] == 0) mark(grid, r+1, c, visitedValue);
        if (c > 0 && visited[r][c-1] != visitedValue && grid[r][c-1] == 0) mark(grid, r, c-1, visitedValue);
        if (c < n-1 && visited[r][c+1] != visitedValue && grid[r][c+1] == 0) mark(grid, r, c+1, visitedValue);
    }
}