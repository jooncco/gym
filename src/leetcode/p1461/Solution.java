package leetcode.p1461;
// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        boolean exist[]= new boolean[1<<k];
        for (int i=0; i+k <= s.length(); ++i) {
            exist[getIntValue(s.substring(i,i+k), k)]= true;
        }
        boolean ans= true;
        for (int i=0; i < 1<<k; ++i) {
            if (!exist[i]) {
                ans= false;
                break;
            }
        }
        return ans;
    }

    private int getIntValue(final String code, final int k) {
        int val= 0, d= 2;
        if (code.charAt(k-1) == '1') val= 1;
        for (int i=k-2; i >= 0; --i) {
            if (code.charAt(i) == '1') {
                val += d;
            }
            d <<= 1;
        }
        return val;
    }
}