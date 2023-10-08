package leetcode.lw366.B;
// https://leetcode.com/contest/weekly-contest-366/problems/minimum-processing-time/

import java.util.*;

/**
 * Greedy
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int n= processorTime.size();
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int ans= 0, idx= tasks.size()-1;
        for (int i=0; i < n; ++i) {
            for (int j= 0; j < 4; ++j) {
                ans= Math.max(ans, processorTime.get(i)+tasks.get(idx));
                --idx;
            }
        }
        return ans;
    }
}