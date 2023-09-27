package leetcode.p880;
// https://leetcode.com/problems/decoded-string-at-index/

/**
 * Implementation, Math
 * | Time: O(|s|)
 * | Space: O(|s|)
 */
public class Solution {
    public String decodeAtIndex(String s, int k) {
        int cnt= 0, idx= 0;
        char lastChar= '-';
        while (k > 0) {
            if (!isDigit(s.charAt(idx))) {
                lastChar= s.charAt(idx);
                ++cnt;
                if (cnt == k) return s.charAt(idx)+"";
                ++idx;
            } else {
                if (cnt*1L*(s.charAt(idx)-'0') >= k) {
                    while (k >= cnt) k -= cnt;
                    if (k == 0) return lastChar+"";
                    idx= cnt= 0;
                } else {
                    cnt *= s.charAt(idx)-'0';
                    ++idx;
                }
            }
        }
        return s.charAt(idx)+"";
    }

    private boolean isDigit(char c) {
        return c-'0' >= 0 && c-'0' < 10;
    }
}