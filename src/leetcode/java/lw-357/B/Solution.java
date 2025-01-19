package leetcode.java.lw-357. B;
// https://leetcode.com/contest/weekly-contest-357/problems/check-if-it-is-possible-to-split-array/

import java.util.List;

/**
 * Greedy
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() <= 2)
            return true;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) + nums.get(i - 1) >= m)
                return true;
        }
        return false;
    }
}