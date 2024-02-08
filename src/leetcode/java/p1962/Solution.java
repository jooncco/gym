package leetcode.java.p1962;
// https://leetcode.com/problems/remove-stones-to-minimize-the-total/

import java.util.PriorityQueue;

public class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;
        for (int pile : piles) {
            pq.add(pile);
            ans += pile;
        }
        while (k-- > 0) {
            int pile = pq.poll();
            pq.add(pile - pile / 2);
            ans -= pile / 2;
        }
        return ans;
    }
}