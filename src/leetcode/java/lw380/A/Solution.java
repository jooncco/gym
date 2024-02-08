package leetcode.java.lw380.A;
// https://leetcode.com/contest/weekly-contest-380/problems/count-elements-with-maximum-frequency/

import java.util.*;

/**
 * Data Structures
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mx = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            mx = Math.max(mx, map.get(num));
        }
        int ans = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() == mx) {
                ans += entry.getValue();
            }
        }
        return ans;
    }
}