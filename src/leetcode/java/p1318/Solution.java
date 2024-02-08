package leetcode.java.p1318;
// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

/**
 * Ad hoc
 * | Time : O (1)
 * | Space: O (1)
 */
public class Solution {
    private static final int INT_LEN = 32;

    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < INT_LEN; ++i) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0)
                    ++ans;
            } else {
                if ((a & 1) == 1)
                    ++ans;
                if ((b & 1) == 1)
                    ++ans;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return ans;
    }
}