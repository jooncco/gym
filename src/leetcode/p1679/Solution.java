package leetcode.p1679;
// https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.Arrays;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        int n= nums.length;
        if (n == 1) return 0;

        Arrays.sort(nums);
        int l= 0, r= n-1, ans= 0;
        while (l < r) {
            if (nums[r]+nums[l] > k) {
                --r;
                continue;
            }
            if (nums[l]+nums[r] < k) {
                ++l;
                continue;
            }
            if (nums[l]+nums[r] == k) {
                ++ans;
                ++l;
                --r;
            }
        }
        return ans;
    }
}