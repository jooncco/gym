package leetcode.java.p2279;
// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/

import java.util.Arrays;

public class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        final int n = capacity.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; ++i)
            diff[i] = capacity[i] - rocks[i];
        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (diff[i] > additionalRocks)
                break;
            additionalRocks -= diff[i];
            ++ans;
        }
        return ans;
    }
}