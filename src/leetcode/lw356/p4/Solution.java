package leetcode.lw356.p4;
// https://leetcode.com/contest/weekly-contest-356/problems/count-stepping-numbers-in-range/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (400n)
 * | Space: O (40n)
 */
public class Solution {
    private final int MOD= (int)(1e9)+7;
    private int[][][][] cache;

    public int countSteppingNumbers(String low, String high) {
        init();
        int l= count(0, 1, 1, 0, low);
        init();
        int r= count(0, 1, 1, 0, high);
        int ans= (r-l+MOD)%MOD;
        boolean lowIsStepping= true;
        for (int i=1; i < low.length(); ++i) {
            if (Math.abs(low.charAt(i)-low.charAt(i-1)) != 1) {
                lowIsStepping= false;
            }
        }
        return lowIsStepping ? (ans+1)%MOD : ans;
    }

    private int count(int idx, int limited, int isZero, int prevDigit, String num) {
        System.out.println(idx+","+limited+","+isZero+","+prevDigit+",");
        if (idx == num.length()) return isZero^1;
        if (cache[idx][limited][isZero][prevDigit] > -1) {
            return cache[idx][limited][isZero][prevDigit];
        }

        cache[idx][limited][isZero][prevDigit]= 0;
        int limit= limited == 1 ? num.charAt(idx)-'0' : 9;
        for (int i=0; i <= limit; ++i) {
            if (isZero == 0 && Math.abs(prevDigit-i) != 1) continue;

            int nextLimited= (limited == 1 && num.charAt(idx)-'0' == i) ? 1 : 0;
            int nextIsZero= isZero == 1 && i == 0 ? 1 : 0;
            cache[idx][limited][isZero][prevDigit] += count(idx+1, nextLimited, nextIsZero, i, num);
            cache[idx][limited][isZero][prevDigit] %= MOD;
        }
        return cache[idx][limited][isZero][prevDigit];
    }

    private void init() {
        cache= new int[101][2][2][10];
        for (int i=0; i < 101; ++i) {
            for (int j=0; j < 2; ++j) {
                for (int k=0; k < 2; ++k) {
                    for (int l=0; l < 10; ++l) {
                        cache[i][j][k][l]= -1;
                    }
                }
            }
        }
    }
}