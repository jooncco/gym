package leetcode.java.p97;

import java.util.Arrays;

public class Solution {
    private String s1, s2, s3;
    private int L, R, I;
    private Boolean[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        L = s1.length();
        R = s2.length();
        I = s3.length();
        this.cache = new Boolean[L][R];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        for (int i = 0; i < L; ++i)
            Arrays.fill(cache[i], null);
        return helper(0, 0, 0);
    }

    private boolean helper(int l, int r, int i) {
        if (i == I)
            return l == L && r == R;
        if (l == L) {
            if (r == R || s2.charAt(r) != s3.charAt(i))
                return false;
            return helper(l, r + 1, i + 1);
        }
        if (r == R) {
            if (l == L || s1.charAt(l) != s3.charAt(i))
                return false;
            return helper(l + 1, r, i + 1);
        }

        if (cache[l][r] != null)
            return cache[l][r];

        cache[l][r] = false;
        char target = s3.charAt(i);
        if (s1.charAt(l) == target && helper(l + 1, r, i + 1)) {
            cache[l][r] = true;
        }
        if (s2.charAt(r) == target && helper(l, r + 1, i + 1)) {
            cache[l][r] = true;
        }
        return cache[l][r];
    }
}