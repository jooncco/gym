package leetcode.java.p72;
// https://leetcode.com/problems/edit-distance/

/**
 * Dynamic Programming (Top down)
 * Time: O(mn)
 * Space: O(mn)
 */
public class Solution {
    private int m, n;
    private int[][] cache;
    private static final int INF = Integer.MAX_VALUE;

    public int minDistance(String A, String B) {
        m = A.length();
        n = B.length();
        cache = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                cache[i][j] = -1;
            }
        }
        return minDistance(A, B, m, n);
    }

    private int minDistance(String A, String B, int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (cache[a][b] > -1)
            return cache[a][b];

        int ret = INF;
        if (A.charAt(a - 1) == B.charAt(b - 1)) {
            ret = minDistance(A, B, a - 1, b - 1);
        } else {
            // replace
            ret = Math.min(ret, 1 + minDistance(A, B, a - 1, b - 1));
            // delete
            ret = Math.min(ret, 1 + minDistance(A, B, a - 1, b));
            // insert
            ret = Math.min(ret, 1 + minDistance(A, B, a, b - 1));
        }
        return cache[a][b] = ret;
    }
}