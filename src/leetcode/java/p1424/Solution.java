package leetcode.java.p1424;
// https://leetcode.com/problems/diagonal-traverse-ii/

import java.util.*;

/**
 * Sortings, Math
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int total = 0;
        for (List<Integer> row : nums) {
            total += row.size();
        }

        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < nums.size(); ++r) {
            for (int c = 0; c < nums.get(r).size(); ++c) {
                list.add(new int[] { r + c, r, c });
            }
        }
        list.sort((a, b) -> a[0] == b[0]
                ? -Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]));
        int[] ans = new int[total];
        int idx = 0;
        for (int[] rc : list) {
            ans[idx++] = nums.get(rc[1]).get(rc[2]);
        }
        return ans;
    }
}