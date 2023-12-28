package leetcode.p1531;
// https://leetcode.com/problems/string-compression-ii/

/**
 * DP (Bottom-up)
 * | Time: O(kn^2)
 * | Space: O(nk)
 */
public class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        final int n= s.length(), INF= 987654321;
        int[][] cc= new int[n+1][k+1];
        for (int i=1; i <= n; ++i) {
            for (int chance=0; chance <= k; ++chance) {
                cc[i][chance]= INF;
                int same= 0, diff= 0;
                for (int idx= i; idx >= 1; --idx) {
                    if (s.charAt(idx-1) == s.charAt(i-1)) ++same;
                    else ++diff;

                    if (diff <= chance) {
                        // compress with s[i]
                        cc[i][chance]= Math.min(
                                cc[i][chance],
                                cc[idx-1][chance-diff] + 1 + (same >= 100 ? 3 : same >= 10 ? 2 : same >= 2 ? 1 : 0));
                    }
                }
                if (chance > 0) {
                    // delete s[i]
                    cc[i][chance]= Math.min(cc[i][chance], cc[i-1][chance-1]);
                }
            }
        }
        return cc[n][k];
    }
}