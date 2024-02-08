package leetcode.java.p2187;
// https://leetcode.com/problems/minimum-time-to-complete-trips/

public class Solution {
    public long minimumTime(int[] times, int totalTrips) {
        long l = 1, r = 1000L * 1000 * 1000 * 1000 * 100;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (isGood(times, m, totalTrips))
                r = m;
            else
                l = m + 1;
        }
        return isGood(times, l, totalTrips) ? l : l + 1;
    }

    private boolean isGood(int[] times, long givenTime, long totalTrips) {
        long trips = 0;
        for (int time : times) {
            trips += givenTime / time;
        }
        return trips >= totalTrips;
    }
}