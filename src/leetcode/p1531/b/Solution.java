package leetcode.p1531.b;

/**
 * DP (Top-down)
 * | Tiem: O(kn^2)
 * | Space: O(nk)
 */
public class Solution {
    private int n;
    private String str;
    private int[][] cc;

    public int getLengthOfOptimalCompression(String s, int k) {
        n= s.length(); str= s;
        cc= new int[n+1][k+1];
        for (int i= 0; i <= n; ++i) {
            for (int j= 0; j <= k; ++j) {
                cc[i][j]= -1;
            }
        }
        return getOptimalLength(1, k);
    }

    private int getOptimalLength(int idx, int k) {
        if (idx == n+1) return 0;
        if (n-idx+1 <= k) return 0;
        if (cc[idx][k] != -1) return cc[idx][k];

        int ret= k > 0 ? getOptimalLength(idx+1, k-1) : 987654321;
        for (int chance= 0; chance <= k; ++chance) {
            int same= 0, diff= 0;
            for (int r=idx; r <= n; ++r) {
                if (str.charAt(r-1) == str.charAt(idx-1)) ++same;
                else ++diff;
                if (diff > chance) break;
                ret= Math.min(
                    ret,
                    (same == 1 ? 1 : (same+"").length()+1) + getOptimalLength(r+1, chance-diff));
            }
        }
        return cc[idx][k]= ret;
    }
}
