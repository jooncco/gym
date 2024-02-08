package leetcode.java.p1675;
// https://leetcode.com/problems/minimize-deviation-in-array/

import java.util.PriorityQueue;

public class Solution {
    public int minimumDeviation(int[] nums) {
        // find minimum value
        int mn = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max-heap
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1)
                nums[i] *= 2;
            pq.add(nums[i]);
            mn = Math.min(mn, nums[i]);
        }

        int deviation = Integer.MAX_VALUE;
        while (pq.peek() % 2 == 0) {
            int mx = pq.poll();
            deviation = Math.min(deviation, mx - mn);
            pq.add(mx / 2);
            mn = Math.min(mn, mx / 2);
        }
        return Math.min(deviation, pq.peek() - mn);
    }
}