package leetcode.p452;
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points);
        int ans= 1, R= points[0][1];
        for (int i=1; i < points.length; ++i) {
            if (points[i][0] <= R) {
                R= Math.min(R, points[i][1]);
            } else {
                ++ans;
                R= points[i][1];
            }
        }
        return ans;
    }
}
