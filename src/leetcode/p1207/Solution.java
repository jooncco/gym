package leetcode.p1207;
// https://leetcode.com/problems/unique-number-of-occurrences/

import java.util.*;

/**
 * Data Structures(Map)
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq= new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        Set<Integer> set= new HashSet<>();
        for (var entry : freq.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }
}