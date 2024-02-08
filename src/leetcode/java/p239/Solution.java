package leetcode.java.p239;
// https://leetcode.com/problems/sliding-window-maximum/

import java.util.*;

/**
 * DP, Monotone Deque
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.pollLast();
            deque.add(i);
            if (deque.getFirst() <= i - k)
                deque.pollFirst();
            if (i >= k - 1)
                ans[i - k + 1] = nums[deque.getFirst()];
        }
        return ans;
    }
}