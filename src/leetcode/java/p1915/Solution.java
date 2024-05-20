package leetcode.java.p1915;
// https://leetcode.com/problems/number-of-wonderful-substrings/

/**
 * Bitmask
 * Time: O(10n)
 * Space: O(n)
 */
public class Solution {
    public long wonderfulSubstrings(String word) {
        long[] maskCnt = new long[1024];
        maskCnt[0] = 1;
        int mask = 0;
        long ans = 0;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            mask ^= (1 << idx);
            ans += maskCnt[mask];
            for (int i = 1; i < 1024; i <<= 1) {
                int prefixMask = mask ^ i;
                ans += maskCnt[prefixMask];
            }
            ++maskCnt[mask];
        }
        return ans;
    }
}