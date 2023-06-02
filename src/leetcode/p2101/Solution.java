package leetcode.p2101;
// https://leetcode.com/problems/detonate-the-maximum-bombs/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Breadth First Search
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n= bombs.length;
        Map<Integer, List<Integer>> inRange= new HashMap<>();
        for (int i=0; i < n; ++i) {
            for (int j=0; j < n; ++j) {
                if (i == j) continue;
                if (isInRange(bombs[i], bombs[j])) {
                    inRange.computeIfAbsent(i, list -> new ArrayList<>()).add(j);
                }
            }
        }
        int ans= 0;
        for (int i=0; i < n; ++i) {
            int cnt= 1;
            boolean[] detonated= new boolean[n];
            detonated[i]= true;
            Queue<Integer> queue= new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur= queue.poll();
                if (inRange.get(cur) != null) for (int bomb : inRange.get(cur)) {
                    if (!detonated[bomb]) {
                        ++cnt;
                        detonated[bomb]= true;
                        queue.add(bomb);
                    }
                }
            }
            ans= Math.max(ans, cnt);
        }
        return ans;
    }

    private boolean isInRange(int[] from, int[] to) {
        long a= from[0]-to[0], b= from[1]-to[1], r= from[2];
        return a*a + b*b <= r*r;
    }
}
