package leetcode.p1091;
// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search
 * | Time: O (nm)
 * | Space: O (nm)
 */
public class Solution {
    private static final int[] dy= {-1, -1, -1, 0, 0, 1, 1, 1}, dx= {-1, 0, 1, -1, 1, -1, 0, 1};
    private int n, m;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        n= grid.length; m= grid[0].length;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0]= 1;
        while (!queue.isEmpty()) {
            int[] cur= queue.poll();
            int y= cur[0], x= cur[1], len= cur[2];
            if (y == n-1 && x == m-1) return len;
            for (int i=0; i < 8; ++i) {
                int ny= y + dy[i], nx= x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (grid[ny][nx] != 0) continue;
                grid[ny][nx]= 1;
                queue.add(new int[]{ny, nx, len+1});
            }
        }
        return -1;
    }
}