package leetcode.java.p72;
// https://leetcode.com/problems/edit-distance/

public class Solution {
    private final int POSITIVE_INFINITY = 999999999;
    private int[][] cache;
    private String A, B;
    private int n, m;

    public int minDistance(String word1, String word2) {
        A = word1;
        B = word2;
        n = word1.length();
        m = word2.length();
        cache = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cache[i][j] = -1;
            }
        }
        return dp(0, 0);
    }

    private int dp(int a, int b) {
        if (a == n && b == m)
            return 0;
        if (a == n)
            return 1 + dp(a, b + 1);
        if (b == m)
            return 1 + dp(a + 1, b);
        if (cache[a][b] > -1)
            return cache[a][b];

        cache[a][b] = POSITIVE_INFINITY;
        if (A.charAt(a) != B.charAt(b)) {
            cache[a][b] = Math.min(cache[a][b], 1 + dp(a + 1, b));
            cache[a][b] = Math.min(cache[a][b], 1 + dp(a, b + 1));
            cache[a][b] = Math.min(cache[a][b], 1 + dp(a + 1, b + 1));
        } else {
            cache[a][b] = Math.min(cache[a][b], dp(a + 1, b + 1));
        }
        return cache[a][b];
    }
}