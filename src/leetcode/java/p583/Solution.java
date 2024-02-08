package leetcode.java.p583;
// https://leetcode.com/problems/delete-operation-for-two-strings/submissions/

import java.util.Arrays;

public class Solution {
    private int n, m;
    private int[][] cache;

    public int minDistance(String word1, String word2) {
        this.n = word1.length();
        this.m = word2.length();
        cache = new int[n][m];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(cache[i], -1);
        }

        int lcsLength = lcs(word1, word2, 0, 0);
        return n + m - 2 * lcsLength;
    }

    private int lcs(final String w1, final String w2, final int l, final int r) {
        if (l == n || r == m)
            return 0;
        if (cache[l][r] > -1)
            return cache[l][r];

        int lcsLength = 0;
        if (w1.charAt(l) == w2.charAt(r)) {
            lcsLength = 1 + lcs(w1, w2, l + 1, r + 1);
        } else {
            lcsLength = Math.max(lcsLength, lcs(w1, w2, l + 1, r));
            lcsLength = Math.max(lcsLength, lcs(w1, w2, l, r + 1));
        }
        cache[l][r] = lcsLength;
        return lcsLength;
    }
}