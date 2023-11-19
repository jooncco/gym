package leetcode.p1887;
// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/

import java.util.*;

/**
 * Sortings, Math
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length, ans= 0, l= 0;
        for (int r=1; r < n; ++r) {
            if (nums[r] == nums[l]) continue;
            l= r;
            ans += n-r;
        }
        return ans;
    }
}