package leetcode.java.p1266;
// https://leetcode.com/problems/minimum-time-visiting-all-points/

/**
 * Math
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int x = points[i][0], y = points[i][1];
            int prevX = points[i - 1][0], prevY = points[i - 1][1];
            ans += Math.max(Math.abs(x - prevX), Math.abs(y - prevY));
        }
        return ans;
    }
}