package leetcode.p435;
// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

/**
 * Greedy
 * | Time: O (n logn)
 * | Space: O (1)
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
        int cnt= 0, r= -50000;
        for (int[] interval : intervals) {
            if (r <= interval[0]) {
                ++cnt;
                r= interval[1];
            }
        }
        return intervals.length-cnt;
    }
}