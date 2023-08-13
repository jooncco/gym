package leetcode.lw358.p3;
// https://leetcode.com/contest/weekly-contest-358/problems/minimum-absolute-difference-between-elements-with-constraint/

import java.util.*;

/**
 * Binary Search, Sliding Window
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n= nums.size();
        int ans= Integer.MAX_VALUE;
        TreeMap<Integer, Integer> numCounts= new TreeMap<>();
        for (int i=x; i < n; ++i) {
            int num= nums.get(i-x);
            numCounts.put(num, numCounts.getOrDefault(num, 0)+1);
            int cur= nums.get(i);
            var floor= numCounts.floorKey(cur);
            if (floor != null) ans= Math.min(ans, cur-floor);
            var ceiling= numCounts.ceilingKey(cur);
            if (ceiling != null) ans= Math.min(ans, ceiling-cur);
        }
        return ans;
    }
}