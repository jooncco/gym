package leetcode.p1759;
// https://leetcode.com/problems/count-number-of-homogenous-substrings/

/**
 * Math
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int countHomogenous(String s) {
        s += "/";
        int ans= 0, cnt= 1;
        for (int i= 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i-1)) ++cnt;
            else {
                ans= add(ans, div(mul(cnt, cnt+1), 2));
                cnt= 1;
            }
        }
        return ans;
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