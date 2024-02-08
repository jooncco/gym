package leetcode.java.p875;
// https://leetcode.com/problems/koko-eating-bananas/

public class Solution {
    private static final int OFF_LIMIT = 1000 * 1000 * 1000;

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 2 * 1000 * 1000 * 1000;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isFastEnough(piles, m, h))
                r = m;
            else
                l = m + 1;
        }
        return isFastEnough(piles, l, h) ? l : l + 1;
    }

    private boolean isFastEnough(int[] piles, int bananaPerHour, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            if (totalHours > OFF_LIMIT)
                return false;
            totalHours += (pile + bananaPerHour - 1) / bananaPerHour;
        }
        return totalHours <= h;
    }
}