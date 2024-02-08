package leetcode.java.p1833;
// https://leetcode.com/problems/maximum-ice-cream-bars/

import java.util.Arrays;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;
        for (int cost : costs) {
            if (coins < cost)
                break;
            coins -= cost;
            ++bars;
        }
        return bars;
    }
}