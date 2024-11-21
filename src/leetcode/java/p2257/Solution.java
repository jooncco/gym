package leetcode.java.p2257;
// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/

/**
 * DFS
 * Time: O(len(guards) * (M+N) + M*N + len(walls))
 * Space: O(M*N)
 */
public class Solution {
    int[] dy= {-1, 1, 0, 0}, dx= {0, 0, -1, 1};
    int M, N, ans;
    int[][] grid;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        M= m; N= n; ans= m*n - guards.length - walls.length;
        grid= new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]]= -1; // -1: guards
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]]= -2; // -2: walls
        }

        for (int[] guard : guards) {
            for (int i=0; i < 4; ++i) {
                int ny= guard[0] + dy[i], nx= guard[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= M || nx >= N || grid[ny][nx] < 0) continue;
                dfs(ny, nx, i);
            }
        }
        return ans;
    }

    void dfs(int r, int c, int dir) {
        if (grid[r][c] == 0) --ans;
        grid[r][c]= 1;

        int ny, nx;
        for (int i=0; i < 4; ++i) {
            if (i != dir) continue;
            ny= r + dy[i]; nx= c + dx[i];
            if (ny < 0 || nx < 0 || ny >= M || nx >= N || grid[ny][nx] < 0) continue;
            dfs(ny, nx, i);
        }
    }
}