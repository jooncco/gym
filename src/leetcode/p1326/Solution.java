package leetcode.p1326;
// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

import java.util.*;

/**
 * Greedy, Sortings
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int i=0; i <= n; ++i) {
            if (ranges[i] == 0) continue;
            pq.add(new int[]{Math.max(0, i-ranges[i]), i+ranges[i]});
        }
        int cnt= 0, R= 0;
        while (!pq.isEmpty()) {
            if (R >= n) break;
            ++cnt;
            int nextR= R;
            while (!pq.isEmpty() && R >= pq.peek()[0]) {
                nextR= Math.max(nextR, pq.poll()[1]);
            }
            if (nextR == R) return -1;
            R= nextR;
        }
        return R >= n ? cnt : -1;
    }
}