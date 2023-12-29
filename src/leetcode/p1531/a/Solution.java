package leetcode.p1531.a;
// https://leetcode.com/problems/string-compression-ii/

/**
 * DP (Bottom-up)
 * | Time: O(kn^2)
 * | Space: O(nk)
 */
public class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] cc= new int[s.length()+1][k+1];
        for (int r= 1; r <= s.length(); ++r) {
            for (int chance= 0; chance <= k; ++chance) {
                cc[r][chance]= 987654321;
                if (chance > 0) {
                    cc[r][chance]= cc[r-1][chance-1];
                }
                int same= 0, diff= 0;
                for (int l=r; l >= 1; --l) {
                    if (s.charAt(l-1) == s.charAt(r-1)) ++same;
                    else ++diff;
                    if (diff > chance) break;
                    cc[r][chance]= Math.min(
                        cc[r][chance],
                        cc[l-1][chance-diff] + (same == 1 ? 1 : (same+"").length()+1));
                }
            }
        }
        return cc[s.length()][k];
    }
}