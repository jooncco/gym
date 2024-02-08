package leetcode.java.p935;
// https://leetcode.com/problems/knight-dialer/

import java.util.*;

/**
 * DP (Top-down)
 * | Time: O(10n)
 * | Space: O(10n)
 */
public class Solution {
    private final List<List<Integer>> nextCells = List.of(
            List.of(4, 6),
            List.of(6, 8),
            List.of(7, 9),
            List.of(4, 8),
            List.of(3, 9, 0),
            List.of(),
            List.of(1, 7, 0),
            List.of(2, 6),
            List.of(1, 3),
            List.of(2, 4));
    private int[][] cc = new int[10][5000];
    private int n;

    private int howMany(int cur, int idx) {
        if (idx == n - 1)
            return 1;
        if (cc[cur][idx] != -1)
            return cc[cur][idx];

        cc[cur][idx] = 0;
        for (int nextCell : nextCells.get(cur)) {
            cc[cur][idx] = add(cc[cur][idx], howMany(nextCell, idx + 1));
        }
        return cc[cur][idx];
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

    public int knightDialer(int n) {
        this.n = n;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5000; ++j) {
                cc[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; ++i) {
            ans = add(ans, howMany(i, 0));
        }
        return ans;
    }
}