package leetcode.p1680;
// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

public class Solution {
    private final int MOD= (int)1e9+7;

    public int concatenatedBinary(int n) {
        int ans= 1;
        for (int i= 2; i <= n; ++i) {
            ans <<= computeDigits(i);
            ans += i;
            ans %= MOD;
        }
        return ans;
    }

    private int computeDigits(int num) {
        int digits= 0;
        while (num > 0) {
            ++digits;
            num >>= 1;
        }
        return digits;
    }
}