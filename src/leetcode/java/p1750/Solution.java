package leetcode.java.p1750;
// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

/**
 * Two Pointers
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                break;
            while (l + 1 < r && s.charAt(l) == s.charAt(l + 1))
                ++l;
            while (l < r - 1 && s.charAt(r) == s.charAt(r - 1))
                --r;
            ++l;
            --r;
        }
        return r - l + 1;
    }
}