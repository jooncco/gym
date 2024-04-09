package leetcode.java.p2073;
// https://leetcode.com/problems/time-needed-to-buy-tickets/

/**
 * Math
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; ++i) {
            if (i < k) {
                time += Math.min(tickets[i], tickets[k]);
            } else if (i > k) {
                time += Math.min(tickets[i], Math.max(0, tickets[k] - 1));
            } else {
                time += tickets[k];
            }
        }
        return time;
    }
}