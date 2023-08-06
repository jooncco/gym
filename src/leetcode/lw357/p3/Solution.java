package leetcode.lw357.p3;
// https://leetcode.com/contest/weekly-contest-357/problems/find-the-safest-path-in-a-grid/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 * | Time: O (n^2)
 * | Space: O (n^2)
 */
public class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n= grid.size();
        int[][] safety= new int[n][n];
        for (int i=0; i < n; ++i)
            for (int j=0; j < n; ++j)
                safety[i][j]= Integer.MAX_VALUE;
        Queue<int[]> queue= new LinkedList<>();
        for (int i=0; i < n; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i,j,0});
                    safety[i][j]= 0;
                }
            }
        }
        final int[] dy= {-1, 1, 0, 0}, dx= {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur= queue.poll();
            int ny, nx;
            for (int i=0; i < 4; ++i) {
                ny= cur[0]+dy[i]; nx= cur[1]+dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (cur[2]+1 >= safety[ny][nx]) continue;
                safety[ny][nx]= cur[2]+1;
                queue.add(new int[]{ny, nx, cur[2]+1});
            }
        }

        int[][] maxSafety= new int[n][n];
        maxSafety[0][0]= safety[0][0];
        Queue<int[]> pathQueue= new LinkedList<>();
        pathQueue.add(new int[]{0, 0, safety[0][0]});
        while (!pathQueue.isEmpty()) {
            int[] cur= pathQueue.poll();
            int y= cur[0], x= cur[1];
            if (cur[2] < maxSafety[y][x]) continue;

            int ny, nx;
            for (int i=0; i < 4; ++i) {
                ny= y+dy[i]; nx= x+dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (Math.min(cur[2], safety[ny][nx]) <= maxSafety[ny][nx]) continue;
                maxSafety[ny][nx]= Math.min(cur[2], safety[ny][nx]);
                pathQueue.add(new int[]{ny, nx, Math.min(cur[2], safety[ny][nx])});
            }
        }
        return maxSafety[n-1][n-1];
    }
}