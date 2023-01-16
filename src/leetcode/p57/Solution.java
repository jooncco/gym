package leetcode.p57;
// https://leetcode.com/problems/insert-interval/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // overlap ?
        boolean overlap= false;
        int start= -1, end= -1;
        for (int[] interval : intervals) {
            if (!(interval[1] < newInterval[0] || interval[0] > newInterval[1])) {
                if (!overlap) start= Math.min(interval[0], newInterval[0]);
                end= Math.max(interval[1], newInterval[1]);
                overlap= true;
            }
        }
        if (!overlap) {
            start= newInterval[0];
            end= newInterval[1];
        }
        // insert
        List<int[]> newIntervals= new LinkedList<>();
        boolean inserted= false;
        for (int[] interval : intervals) {
            if (interval[1] < start) {
                newIntervals.add(interval);
            }
            if (interval[0] > end) {
                if (!inserted) {
                    newIntervals.add(new int[]{start, end});
                    inserted= true;
                }
                newIntervals.add(interval);
            }
        }
        if (!inserted) newIntervals.add(new int[]{start, end});
        int[][] ret= new int[newIntervals.size()][2];
        for (int i=0; i < ret.length; ++i) {
            ret[i]= newIntervals.get(i);
        }
        return ret;
    }
}