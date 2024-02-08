package leetcode.java.p1814;
// https://leetcode.com/problems/count-nice-pairs-in-an-array/

import java.util.*;

/**
 * Math (Equation)
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            int sub = num - rev(num);
            ans = add(ans, cnt.getOrDefault(sub, 0));
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
        }
        return ans;
    }

    private int rev(int num) {
        int ret = 0;
        while (num > 0) {
            ret *= 10;
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }

    private static final int MOD = (int) 1e9 + 7;

    private static int add(int a, int b) {
        return (int) ((a + 0L + b) % MOD);
    }

    private static int mul(int a, int b) {
        return (int) (a * 1L * b % MOD);
    }

    private static int inv(int a) {
        return binEx(a, MOD - 2);
    }

    private static int div(int a, int b) {
        return mul(a, inv(b));
    }

    private static int binEx(int a, int x) {
        if (x == 0)
            return 1;
        int p = binEx(a, x >> 1);
        p = mul(p, p);
        return (x & 1) == 1 ? mul(p, a) : p;
    }
}