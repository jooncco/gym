package leetcode.p151;
// https://leetcode.com/problems/reverse-words-in-a-string/
public class Solution {
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        StringBuilder sb= new StringBuilder();
        boolean whitespace= false;
        for (int i=words.length-1; i >= 0; --i) {
            if (words[i].isBlank()) continue;
            if (whitespace) sb.append(" ");
            sb.append(words[i]);
            whitespace= true;
        }
        return sb.toString();
    }
}