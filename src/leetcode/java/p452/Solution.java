package leetcode.java.p452;
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;

/**
 * Greedy
 * Time: O(n log(n))
 * Space: O(1)
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int shots = 1;
        int currentEnd = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] <= currentEnd) {
                currentEnd = Math.min(currentEnd, points[i][1]);
            } else {
                ++shots;
                currentEnd = points[i][1];
            }
        }
        return shots;
    }
}