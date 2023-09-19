package leetcode.p287;
// https://leetcode.com/problems/find-the-duplicate-number/

/**
 * Math (Pigeonhole principle)
 * | Time: O(nlog(nums[i]))
 * | Space: O(20)
 */
public class Solution {
    private final int LIMIT= 20;

    public int findDuplicate(int[] nums) {
        int n= nums.length-1;
        int[] limit= new int[LIMIT];
        for (int i=1; i <= n; ++i) {
            countAndAddBinaryDigits(limit, i);
        }
        int[] cnt= new int[LIMIT];
        for (int num : nums) {
            countAndAddBinaryDigits(cnt, num);
        }

        // compare and compute answer
        int ans= 0;
        boolean shift= false;
        for (int i=0; i < LIMIT; ++i) {
            if (cnt[i] > limit[i]) {
                ++ans;
                shift= true;
            }
            if (shift && i < LIMIT-1) ans <<= 1;
        }
        return ans;
    }

    private void countAndAddBinaryDigits(int[] cnt, int num) {
        int idx= LIMIT-1;
        while (num > 0) {
            if ((num&1) == 1) {
                ++cnt[idx];
            }
            num >>= 1;
            --idx;
        }
    }
}