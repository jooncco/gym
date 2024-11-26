package leetcode.java.p151;
// https://leetcode.com/problems/reverse-words-in-a-string/

/**
 * String
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        StringBuilder sb= new StringBuilder();
        sb.append(words[words.length-1]);
        for (int i= words.length-2; i >= 0; --i) {
            if (words[i].isBlank()) continue;
            sb.append(" ").append(words[i]);
        }
        return sb.toString();
    }
}