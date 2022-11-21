package leetcode.p1926;
// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int[] dr= {-1, 1, 0, 0}, dc= {0, 0, -1, 1};
    private int m, n;
    private boolean[][] visited;

    public int nearestExit(char[][] maze, int[] entrance) {
        m= maze.length; n= maze[0].length;
        visited= new boolean[m][n];
        Queue<Vertex> queue= new LinkedList<>();
        queue.add(new Vertex(entrance[0], entrance[1], 0));
        boolean isEntrance= true;
        visited[entrance[0]][entrance[1]]= true;
        while (!queue.isEmpty()) {
            Vertex cur= queue.poll();
            if (!isEntrance && (cur.r == 0 || cur.r == m-1 || cur.c == 0 || cur.c == n-1)) return cur.distance;
            isEntrance= false;

            int nr, nc;
            for (int i=0; i < 4; ++i) {
                nr= cur.r + dr[i];
                nc= cur.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (visited[nr][nc] || maze[nr][nc] == '+') continue;
                visited[nr][nc]= true;
                queue.add(new Vertex(nr, nc, cur.distance+1));
            }
        }
        return -1;
    }

    static class Vertex {
        int r, c, distance;

        Vertex(int r, int c, int distance) {
            this.r= r;
            this.c= c;
            this.distance= distance;
        }
    }
}