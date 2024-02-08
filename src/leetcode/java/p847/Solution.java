package leetcode.java.p847;
// https://leetcode.com/problems/shortest-path-visiting-all-nodes/

import java.util.*;

/**
 * BFS, Back Tracking
 * | Time: O(n * 2^n)
 * | Space: O(n * 2^n)
 */
public class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            int mask = 1 << (i + 4) | i;
            queue.add(mask);
            visited.add(mask);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int cur = queue.poll();
                if ((cur >> 4) == (1 << n) - 1)
                    return cnt;
                for (int there : graph[cur & ((1 << 4) - 1)]) {
                    int nextMask = (cur | 1 << there + 4) >> 4 << 4 | there;
                    if (visited.contains(nextMask))
                        continue;
                    queue.add(nextMask);
                    visited.add(nextMask);
                }
            }
            ++cnt;
        }
        return -1;
    }
}