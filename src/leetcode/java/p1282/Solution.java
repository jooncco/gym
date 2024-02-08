package leetcode.java.p1282;
// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

import java.util.*;

/**
 * Constructive Algorithms
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.computeIfAbsent(groupSizes[i], list -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int size : map.keySet()) {
            List<Integer> indices = map.get(size);
            for (int i = 0; i < indices.size() / size; ++i) {
                List<Integer> list = new ArrayList<>();
                for (int j = size * i; j < size * (i + 1); ++j) {
                    list.add(indices.get(j));
                }
                ans.add(list);
            }
        }
        return ans;
    }
}