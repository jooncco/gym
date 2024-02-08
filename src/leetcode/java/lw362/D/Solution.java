package leetcode.java.lw362.D;
// https://leetcode.com/contest/weekly-contest-362/problems/string-transformation/

import java.util.*;

/**
 * KMP Algorithm, Math
 * | Time: O(nlog(k))
 * | Space: O(n)
 */
public class Solution {
    public int numberOfWays(String s, String t, long k) {
        int n = t.length();
        int fki = add(binEx(n - 1, k), k % 2 == 0 ? -1 : 1);
        fki = div(fki, n);
        int fk0 = add(fki, k % 2 == 0 ? 1 : -1);

        int ans = 0;
        Kmp kmp = new Kmp(t);
        List<Integer> indices = kmp.getMatchIndices(s + s);
        for (int idx : indices) {
            if (idx == 0)
                ans = add(ans, fk0);
            else
                ans = add(ans, fki);
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

    private static int binEx(int a, long x) {
        if (x == 0)
            return 1;
        int p = binEx(a, x >> 1);
        p = mul(p, p);
        return x % 2 == 1 ? mul(p, a) : p;
    }

    static class Kmp {
        int n;
        char[] p;
        int[] lps;

        Kmp(String pattern) {
            n = pattern.length();
            p = pattern.toCharArray();
            lps = new int[n];
            int len = 0, i = 1;
            while (i < n) {
                if (p[len] == p[i]) {
                    lps[i++] = ++len;
                } else {
                    if (len > 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i++] = 0;
                    }
                }
            }
        }

        List<Integer> getMatchIndices(String text) {
            List<Integer> ret = new ArrayList<>();
            int i = 0, len = 0;
            while (i < text.length()) {
                if (len == n) {
                    ret.add(i - n);
                    len = lps[len - 1];
                    continue;
                }
                if (text.charAt(i) == p[len]) {
                    ++i;
                    ++len;
                } else {
                    if (len > 0)
                        len = lps[len - 1];
                    else
                        ++i;
                }
            }
            return ret;
        }
    }
}