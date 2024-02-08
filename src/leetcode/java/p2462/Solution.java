package leetcode.java.p2462;
// https://leetcode.com/problems/total-cost-to-hire-k-workers/

import java.util.PriorityQueue;

/**
 * Two Pointers
 * | Time: O ((k + c) log c)
 * | Space: O (c)
 */
public class Solution {
    public long totalCost(int[] costs, int k, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int l = 0, r = costs.length - 1;
        for (int i = 0; i < c; ++i) {
            if (l >= r)
                break;
            pq.add(new int[] { costs[l], l++ });
            pq.add(new int[] { costs[r], r-- });
        }
        if (l < c && l == r)
            pq.add(new int[] { costs[l], l++ });
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int[] hired = pq.poll();
            ans += hired[0];
            if (l <= r) {
                if (hired[1] < l)
                    pq.add(new int[] { costs[l], l++ });
                else
                    pq.add(new int[] { costs[r], r-- });
            }
        }
        return ans;
    }
}