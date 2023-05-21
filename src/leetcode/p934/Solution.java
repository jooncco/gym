package leetcode.p934;
// https://leetcode.com/problems/shortest-bridge/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[] dy= {-1, 1, 0, 0}, dx= {0, 0, -1, 1};
    int n, m;

    public int shortestBridge(int[][] grid) {
        n= grid.length; m= grid[0].length;
        // Mark islands (DFS)
        int group= -1;
        for (int i=0; i < n; ++i) {
            for (int j=0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    fill(i, j, grid, group);
                    --group;
                }
            }
        }

        // Enqueue start points
        Queue<int[]> queue= new LinkedList<>();
        for (int i=0; i < n; ++i) {
            for (int j= 0; j < m; ++j) {
                if (grid[i][j] == -2) {
                    for (int d=0; d < 4; ++d) {
                        int ny= i + dy[d], nx= j + dx[d];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                        if (grid[ny][nx] == 0) {
                            grid[ny][nx]= 1;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }

        // Find the shortest way (BFS)
        while (!queue.isEmpty()) {
            int[] cur= queue.poll();
            int r= cur[0], c= cur[1];
            for (int d=0; d < 4; ++d) {
                int ny= r + dy[d], nx= c + dx[d];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (grid[ny][nx] == -1) return grid[r][c];
                if (grid[ny][nx] != 0) continue;
                grid[ny][nx]= grid[r][c]+1;
                queue.add(new int[]{ny, nx});
            }
        }
        return -1;
    }

    private void fill(int r, int c, int[][] grid, int group) {
        grid[r][c]= group;
        for (int d=0; d < 4; ++d) {
            int ny = r + dy[d], nx = c + dx[d];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (grid[ny][nx] != 1) continue;
            fill(ny, nx, grid, group);
        }
    }
}