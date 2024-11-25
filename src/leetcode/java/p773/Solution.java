package leetcode.java.p773;
// https://leetcode.com/problems/sliding-puzzle/

import java.util.*;

/**
 * BFS
 * Time: O(6^6)
 * Space: O(6^6)
 */
public class Solution {
    public int slidingPuzzle(int[][] board) {
        int[] dy= {-1, 1, 0, 0}, dx= {0, 0, -1, 1};
        String target= "123450";
        String boardKey= getKey(board);
        Set<String> visited= new HashSet<>();
        Queue<String> q= new LinkedList<>();
        visited.add(boardKey);
        q.add(boardKey);
        int dist= 0;
        while (!q.isEmpty()) {
            int sz= q.size();
            for (int cnt=0; cnt < sz; ++cnt) {
                String key= q.poll();
                if (target.equals(key)) return dist;
                int[][] cur= getBoard(key);
                int r= -1, c= -1;
                for (int i=0; i < 2; ++i) {
                    for (int j=0; j < 3; ++j) {
                        cur[i][j]= key.charAt(3*i+j)-'0';
                        if (cur[i][j] == 0) {
                            r= i; c= j;
                        }
                    }
                }
                for (int i=0; i < 4; ++i) {
                    int ny= r + dy[i], nx= c + dx[i];
                    if (ny < 0 || nx < 0 || ny >= 2 || nx >= 3) continue;
                    int tmp= cur[ny][nx];
                    cur[ny][nx]= cur[r][c];
                    cur[r][c]= tmp;
                    String nextKey= getKey(cur);
                    cur[r][c]= cur[ny][nx];
                    cur[ny][nx]= tmp;
                    if (visited.contains(nextKey)) continue;
                    visited.add(nextKey);
                    q.add(nextKey);
                }
            }
            ++dist;
        }
        return -1;
    }

    private String getKey(int[][] board) {
        StringBuilder sb= new StringBuilder();
        for (int i=0; i < 2; ++i) {
            for (int j=0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private int[][] getBoard(String key) {
        int[][] board= new int[2][3];
        for (int i=0; i < 2; ++i) {
            for (int j=0; j < 3; ++j) {
                board[i][j]= key.charAt(i*3+j) - '0';
            }
        }
        return board;
    }
}