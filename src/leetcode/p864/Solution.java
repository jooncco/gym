package leetcode.p864;
// https://leetcode.com/problems/shortest-path-to-get-all-keys/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Bitmask BFS
 * | Time: O (mn)
 * | Space: O (mn)
 */
public class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m= grid.length, n= grid[0].length();
        int[][] D= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int startR= 0, startC= 0, keyCount= 0;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                int c= grid[i].charAt(j);
                if (c == '@') {
                    startR= i; startC= j;
                }
                if (c >= 'a' && c <= 'f') ++keyCount;
            }
        }
        State start= new State(0, startR, startC);
        Queue<State> queue= new LinkedList<>();
        queue.add(start);
        Set<String> visited= new HashSet<>();
        visited.add(start.getHashKey());
        int steps= 0;
        while (!queue.isEmpty()) {
            int size= queue.size();
            while (size-- > 0) {
                State cur= queue.poll();
                if (cur.keys == (1<<keyCount)-1) return steps;
                int ny, nx;
                for (int[] d : D) {
                    ny= cur.r + d[0]; nx= cur.c + d[1];
                    if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                    int keys= cur.keys;
                    int c= grid[ny].charAt(nx);
                    if (c == '#') continue;
                    if (c >= 'A' && c <= 'F') {
                        if ((keys & (1<<(c-'A'))) == 0) continue;
                    }
                    if (c >= 'a' && c <= 'f') keys |= (1<<(c-'a'));
                    State next= new State(keys, ny, nx);
                    if (visited.contains(next.getHashKey())) continue;
                    visited.add(next.getHashKey());
                    queue.add(next);
                }
            }
            ++steps;
        }
        return -1;
    }

    private static class State {
        int keys, r, c;

        State(int keys, int r, int c) {
            this.keys= keys;
            this.r= r;
            this.c= c;
        }

        String getHashKey() {
            return keys + "," + r + "," + c;
        }
    }
}