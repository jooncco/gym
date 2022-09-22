package leetcode.p557;
// https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class Solution {
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        String ret= "";
        for (int i=0; i < words.length; ++i) {
            if (i > 0) ret += " ";
            ret += reverseWord(words[i]);
        }
        return ret;
    }

    private String reverseWord(final String s) {
        String ret= "";
        for (int i=s.length()-1; i >= 0; --i) ret += s.charAt(i);
        return ret;
    }
}