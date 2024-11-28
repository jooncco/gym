package leetcode.java.p2290;
// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/

import java.util.*;

/**
 * BFS
 * Time: O(mn(m+n))
 * Space: O(mn)
 */
public class Solution {
    public int minimumObstacles(int[][] grid) {
        int m= grid.length, n= grid[0].length;
        int[] dy= {-1, 1, 0, 0}, dx= {0, 0, -1, 1};
        int[][] dist= new int[m][n];
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                dist[i][j]= Integer.MAX_VALUE;
            }
        }
        dist[0][0]= 0;
        // bfs
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] here= q.poll();
            int y= here[0], x= here[1], d= here[2];
            for (int i=0; i < 4; ++i) {
                int ny= y+dy[i], nx= x+dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if (grid[ny][nx] == 1 && dist[ny][nx] <= dist[y][x]+1) continue;
                if (grid[ny][nx] == 0 && dist[ny][nx] <= dist[y][x]) continue;
                dist[ny][nx]= grid[ny][nx] == 1 ? dist[y][x]+1 : dist[y][x];
                q.add(new int[]{ny, nx, dist[ny][nx]});
            }
        }
        return dist[m-1][n-1];
    }
}