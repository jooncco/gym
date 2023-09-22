package leetcode.p392;
// https://leetcode.com/problems/is-subsequence/

/**
 * Brute Force
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx= 0;
        for (char c : t.toCharArray()) {
            if (idx == s.length()) break;
            if (s.charAt(idx) == c) {
                ++idx;
            }
        }
        return idx == s.length();
    }
}