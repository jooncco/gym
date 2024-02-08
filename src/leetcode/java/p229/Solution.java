package leetcode.java.p229;
// https://leetcode.com/problems/majority-element-ii/

import java.util.*;

/**
 * Sortings
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1])
                ++cnt;
            else {
                if (cnt > n / 3)
                    ans.add(nums[i - 1]);
                cnt = 1;
            }
        }
        if (cnt > n / 3)
            ans.add(nums[n - 1]);
        return ans;
    }
}