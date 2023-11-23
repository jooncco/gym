package leetcode.p1630;
// https://leetcode.com/problems/arithmetic-subarrays/

import java.util.*;

/**
 * Sortings
 * | Time: O(m n log(n))
 * | Space: O(n + m)
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans= new ArrayList<>();
        int m= l.length;
        for (int i=0; i < m; ++i) {
            ans.add(isArithmeticSubarray(nums, l[i], r[i]));
        }
        return ans;
    }

    private boolean isArithmeticSubarray(int[] nums, int l, int r) {
        if (r == l) return false;
        if (r-l == 1) return true;
        int[] subArr= new int[r-l+1];
        for (int i=l; i <= r; ++i) {
            subArr[i-l]= nums[i];
        }
        Arrays.sort(subArr);
        int diff= subArr[1]-subArr[0];
        for (int i=2; i < subArr.length; ++i) {
            if (subArr[i]-subArr[i-1] != diff) return false;
        }
        return true;
    }
}