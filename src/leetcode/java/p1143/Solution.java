package leetcode.java.p1143;
// https://leetcode.com/problems/longest-common-subsequence/

public class Solution {
    private int m, n;
    private int[][] cache;

    public int longestCommonSubsequence(String A, String B) {
        m = A.length();
        n = B.length();
        cache = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cache[i][j] = -1;
            }
        }
        return lcs(A, B, 0, 0);
    }

    private int lcs(String A, String B, int l, int r) {
        if (l == m || r == n)
            return 0;
        if (cache[l][r] > -1)
            return cache[l][r];

        cache[l][r] = 0;
        if (A.charAt(l) == B.charAt(r)) {
            cache[l][r] = 1 + lcs(A, B, l + 1, r + 1);
        } else {
            cache[l][r] = Math.max(lcs(A, B, l + 1, r), lcs(A, B, l, r + 1));
        }
        return cache[l][r];
    }
}