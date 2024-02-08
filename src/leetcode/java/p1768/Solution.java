package leetcode.java.p1768;
// https://leetcode.com/problems/merge-strings-alternately/

/**
 * Ad hoc
 * | Time: O (n + m)
 * | Space: O (n + m)
 */
public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0;
        while (l < word1.length() && r < word2.length()) {
            sb.append(word1.charAt(l++));
            sb.append(word2.charAt(r++));
        }
        while (l < word1.length()) {
            sb.append(word1.charAt(l++));
        }
        while (r < word2.length()) {
            sb.append(word2.charAt(r++));
        }
        return sb.toString();
    }
}