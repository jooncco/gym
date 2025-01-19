package leetcode.java.lbw-111.A;
// https://leetcode.com/contest/biweekly-contest-111/problems/number-of-beautiful-integers-in-the-range/

import java.util.*;

/**
 * Brute Force
 * | Time: O (n^2)
 * | Space: O (1)
 */
public class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums.get(i) + nums.get(j) < target)
                    ++ans;
            }
        }
        return ans;
    }
}