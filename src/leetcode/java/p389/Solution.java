package leetcode.java.p389;
// https://leetcode.com/problems/find-the-difference/

/**
 * Brute Force
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            --cnt[c - 'a'];
            if (cnt[c - 'a'] < 0) {
                return c;
            }
        }
        return '-';
    }
}