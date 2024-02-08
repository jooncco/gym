package leetcode.java.p516;
// https://leetcode.com/problems/longest-palindromic-subsequence/

public class Solution2 {
    private int n;
    private int[][] cache;

    public int longestPalindromeSubseq(String s) {
        init(s);
        return maxLen(s, 0, n - 1);
    }

    private void init(String s) {
        n = s.length();
        cache = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cache[i][j] = -1;
            }
        }
    }

    private int maxLen(String s, int l, int r) {
        if (l > r)
            return 0;
        if (l == r)
            return 1;
        if (cache[l][r] > -1)
            return cache[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            cache[l][r] = 2 + maxLen(s, l + 1, r - 1);
        } else {
            cache[l][r] = Math.max(maxLen(s, l + 1, r), maxLen(s, l, r - 1));
        }
        return cache[l][r];
    }
}