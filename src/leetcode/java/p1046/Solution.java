package leetcode.java.p1046;
// https://leetcode.com/problems/last-stone-weight/

import java.util.PriorityQueue;

/**
 * Sorting
 * | Time: O (n logn)
 * | Space: O (n)
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            if (a != b)
                pq.add(a - b);
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}