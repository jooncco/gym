package leetcode.p1020;

public class Solution {
    private int m, n, ans;
    private boolean[][] steppedIn;

    public int numEnclaves(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        ans= 0;
        steppedIn= new boolean[m][n];
        for (int r=0; r < m; ++r) {
            for (int c=0; c < n; ++c) {
                if (grid[r][c] == 1 && !steppedIn[r][c]) {
                    stepIn(grid, r, c, 1);
                }
            }
        }
        for (int r=0; r < m; ++r) {
            if (grid[r][0] == 1 && steppedIn[r][0]) stepIn(grid, r, 0, -1);
            if (grid[r][n-1] == 1 && steppedIn[r][n-1]) stepIn(grid, r, n-1, -1);
        }
        for (int c=0; c < n; ++c) {
            if (grid[0][c] == 1 && steppedIn[0][c]) stepIn(grid, 0, c, -1);
            if (grid[m-1][c] == 1 && steppedIn[m-1][c]) stepIn(grid, m-1, c, -1);
        }
        return ans;
    }

    private void stepIn(int[][] grid, int r, int c, int addVal) {
        steppedIn[r][c]= !steppedIn[r][c];
        ans += addVal;
        if (r > 0 && grid[r-1][c] == 1 && steppedIn[r-1][c] != steppedIn[r][c]) stepIn(grid, r-1, c, addVal);
        if (c > 0 && grid[r][c-1] == 1 && steppedIn[r][c-1] != steppedIn[r][c]) stepIn(grid, r, c-1, addVal);
        if (r < m-1 && grid[r+1][c] == 1 && steppedIn[r+1][c] != steppedIn[r][c]) stepIn(grid, r+1, c, addVal);
        if (c < n-1 && grid[r][c+1] == 1 && steppedIn[r][c+1] != steppedIn[r][c]) stepIn(grid, r, c+1, addVal);
    }
}
