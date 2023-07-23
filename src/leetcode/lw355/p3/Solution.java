package leetcode.lw355.p3;
// https://leetcode.com/contest/weekly-contest-355/problems/maximum-number-of-groups-with-increasing-length/

import java.util.Collections;
import java.util.List;

/**
 * Greedy
 * | Time: O (n log n)
 * | Space: O (1)
 */
public class Solution {
    public int maxIncreasingGroups(List<Integer> L) {
        Collections.sort(L);
        long total= 0, g= 0, n= L.size();
        for (int i=0; i < n; ++i) {
            total += L.get(i);
            if (total >= (g+1)*(g+2)/2) ++g;
        }
        return (int)g;
    }
}