package leetcode.lw366.D;
// https://leetcode.com/contest/weekly-contest-366/problems/apply-operations-on-array-to-maximize-sum-of-squares/

import java.util.*;

/**
 * Greedy
 * | Time: O(31n + 31k)
 * | Space: O(1)
 */
public class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt= new int[32];
        for (int num : nums) {
            for (int i= 0; i < 31; ++i) {
                if ((num&(1<<i)) > 0) ++cnt[i];
            }
        }
        int ans= 0;
        while (k-- > 0) {
            int a= 0, d= 1;
            for (int i=0; i < 31; ++i) {
                if (cnt[i] > 0) {
                    a += d;
                    --cnt[i];
                }
                d <<= 1;
            }
            ans= add(ans, mul(a, a));
        }
        return ans;
    }

    private static final int MOD= (int)1e9+7;
    private static int add(int a, int b) { return (int)((a+0L+b)%MOD); }
    private static int mul(int a, int b) { return (int)(a*1L*b%MOD); }
    private static int inv(int a) { return binEx(a, MOD-2); }
    private static int div(int a, int b) { return mul(a, inv(b)); }
    private static int binEx(int a, int x) {
        if (x == 0) return 1;
        int p= binEx(a, x>>1);
        p= mul(p, p);
        return (x&1) == 1 ? mul(p,a) : p;
    }
}