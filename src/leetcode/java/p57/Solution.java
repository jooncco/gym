package leetcode.java.p57;
// https://leetcode.com/problems/insert-interval/

import java.util.*;

/**
 * Ad hoc
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Find overlapping interval and merge
        // (find merged left and right of new interval)
        int left = -1;
        int right = -1;
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[0] && newInterval[0] <= interval[1]) {
                left = interval[0];
            }
            if (interval[0] <= newInterval[1] && newInterval[1] <= interval[1]) {
                right = interval[1];
            }
        }
        if (left == -1) {
            left = newInterval[0];
        }
        if (right == -1) {
            right = newInterval[1];
        }

        // Add new interval
        // Exclude intervals overlapping with new interval
        List<int[]> list = new ArrayList<>();
        boolean addedNewInterval = false;
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                list.add(interval);
            }
            if (interval[0] > right) {
                if (!addedNewInterval) {
                    list.add(new int[] { left, right });
                    addedNewInterval = true;
                }
                list.add(interval);
            }
        }
        if (!addedNewInterval) {
            list.add(new int[] { left, right });
        }

        return list.toArray(new int[list.size()][]);
    }
}