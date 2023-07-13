package leetcode.p207;
// https://leetcode.com/problems/course-schedule/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Breadth First Search
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, Set<Integer>> edges= new HashMap<>();
        for (int i=0; i < n; ++i) edges.put(i, new HashSet<>());
        int[] prerequisiteCnt= new int[n];
        for (int[] p : prerequisites) {
            ++prerequisiteCnt[p[0]];
            edges.get(p[1]).add(p[0]);
        }
        int courseCnt= 0;
        int[] visitedPreCnt= new int[n];
        Queue<Integer> queue= new LinkedList<>();
        for (int i=0; i < n; ++i) {
            if (prerequisiteCnt[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int sz= queue.size();
            while (sz-- > 0) {
                int cur= queue.poll();
                ++courseCnt;
                for (int there : edges.get(cur)) {
                    ++visitedPreCnt[there];
                    if (visitedPreCnt[there] == prerequisiteCnt[there]) {
                        queue.add(there);
                    }
                }
            }
        }
        return courseCnt == n;
    }
}