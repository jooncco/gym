package leetcode.java.p1011;
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // binary search
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isPossible(weights, m, days))
                r = m;
            else
                l = m + 1;
        }
        return isPossible(weights, l, days) ? l : l + 1;
    }

    private boolean isPossible(int[] weights, int capacity, int days) {
        int dayCount = 1, curWeight = 0;
        for (int weight : weights) {
            if (capacity < weight)
                return false;
            if (curWeight + weight > capacity) {
                ++dayCount;
                curWeight = weight;
            } else
                curWeight += weight;
        }
        return dayCount <= days;
    }
}