package leetcode.p1531;
// https://leetcode.com/problems/string-compression-ii/

import java.util.Arrays;

public class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n= s.length();
        int[][] cache= new int[n+1][k+1];
        for (int[] buffs : cache) Arrays.fill(buffs, 10000);
        cache[0][0]= 0;
        for (int i=1; i <= n; ++i) {
            for (int chance=0; chance <= k; ++chance) {
                int same= 0, diff= 0;
                for (int idx= i; idx >= 1; --idx) {
                    if (s.charAt(idx-1) == s.charAt(i-1)) ++same;
                    else ++diff;

                    // compress with s[i]
                    if (diff <= chance) {
                        cache[i][chance]= Math.min(
                                cache[i][chance],
                                cache[idx-1][chance-diff] + 1 + (same >= 100 ? 3 : same >= 10 ? 2 : same >= 2 ? 1 : 0));
                    }
                }
                if (chance > 0) {
                    // delete s[i]
                    cache[i][chance]= Math.min(cache[i][chance], cache[i-1][chance-1]);
                }
            }
        }
        return cache[n][k];
    }
}