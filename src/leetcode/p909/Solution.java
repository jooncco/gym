package leetcode.p909;
// https://leetcode.com/problems/snakes-and-ladders/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n= board.length;
        int[] next= new int[n*n+1];
        for (int num= 1; num <= n*n; ++num) {
            int[] coordinate= toCoordinate(n, num);
            int i= coordinate[0], j= coordinate[1];
            next[num]= board[i][j] == -1 ? num+1 : board[i][j];
        }
        int[] minMove= new int[n*n+1];
        for (int i=1; i <= n*n; ++i) {
            minMove[i]= Integer.MAX_VALUE;
        }
        minMove[1]= 0;
        Queue<Integer> queue= new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int cur= queue.poll();
            for (int dice= 1; dice <= 6; ++dice) {
                if (cur+dice > n*n) break;
                // ladder or snake ?
                if (next[cur+dice] != cur+dice+1) {
                    if (minMove[next[cur+dice]] > minMove[cur]+1) {
                        minMove[next[cur+dice]]= minMove[cur]+1;
                        queue.add(next[cur+dice]);
                    }
                } else {
                    if (minMove[cur+dice] > minMove[cur]+1) {
                        minMove[cur+dice]= minMove[cur]+1;
                        queue.add(cur+dice);
                    }
                }
            }
        }
        return minMove[n*n] == Integer.MAX_VALUE ? -1 : minMove[n*n];
    }

    private int[] toCoordinate(int n, int num) {
        int i= n-1-(num-1)/n;
        int j= (num-1)/n%2 == 0 ? (num-1)%n : n-1-(num-1)%n;
        return new int[]{i,j};
    }
}