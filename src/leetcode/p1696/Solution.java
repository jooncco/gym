package leetcode.p1696;
// https://leetcode.com/problems/jump-game-vi/

import java.util.*;

/**
 * DP, Monotone Queue
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int maxResult(int[] nums, int k) {
        int n= nums.length;
        int[] cc= new int[n]; cc[0]= nums[0];
        Deque<Integer> deque= new LinkedList<>(); deque.addLast(0);
        for (int i=1; i < n; ++i) {
            cc[i]= nums[i] + cc[deque.getFirst()];

            while (!deque.isEmpty() && cc[deque.getLast()] <= cc[i]) deque.pollLast();
            if (!deque.isEmpty() && deque.getFirst() <= i-k) deque.pollFirst();
            deque.addLast(i);
        }
        return cc[n-1];
    }
}