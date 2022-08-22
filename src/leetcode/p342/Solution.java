package leetcode.p342;

public class Solution {
    public boolean isPowerOfFour(int n) {
        int idx= -1, numOfOnes= 0, i= 0;
        while (n > 0) {
            if ((n&1) == 1) {
                if (numOfOnes > 0) return false;
                ++numOfOnes;
                idx= i;
            }
            ++i;
            n >>= 1;
        }
        return idx%2 == 0;
    }
}