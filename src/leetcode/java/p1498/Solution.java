package leetcode.java.p1498;
// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

import java.util.Arrays;

/**
 * Math, Two Pointers
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            pow[i] = mul(pow[i - 1], 2);
        }
        Arrays.sort(nums);
        int ans = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[l] > target)
                break;
            while (nums[l] + nums[r] > target)
                --r;
            int subsequences = pow[r - l];
            ans = add(ans, subsequences);
            ++l;
        }
        return ans;
    }

    private int add(int a, int b) {
        return (a + b) % MOD;
    }

    private int mul(int a, int b) {
        return (int) (a * 1L * b % MOD);
    }
}