package leetcode.java.p58;
// https://leetcode.com/problems/length-of-last-word/

/**
 * Ad hoc
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            --idx;
        }
        while (idx >= 0 && s.charAt(idx) != ' ') {
            --idx;
            ++len;
        }
        return len;
    }
}