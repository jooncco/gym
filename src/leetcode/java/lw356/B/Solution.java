package leetcode.java.lw356.B;
// https://leetcode.com/contest/weekly-contest-356/problems/count-complete-subarrays-in-an-array/

import java.util.HashSet;
import java.util.Set;

/**
 * Math, Set
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> wholeSet = new HashSet<>();
        for (int num : nums)
            wholeSet.add(num);

        int ans = 0;
        for (int r = 0; r < n; ++r) {
            int l = r;
            Set<Integer> set = new HashSet<>();
            while (l >= 0 && set.size() < wholeSet.size()) {
                set.add(nums[l]);
                --l;
            }
            if (set.size() == wholeSet.size())
                ans += l + 2;
        }
        return ans;
    }
}