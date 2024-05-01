package leetcode.java.p2000;
// https://leetcode.com/problems/reverse-prefix-of-word/

/**
 * Two Pointers
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == ch) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            return word;
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i >= 0; --i) {
            sb.append(word.charAt(i));
        }
        for (int i = idx + 1; i < word.length(); ++i) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
