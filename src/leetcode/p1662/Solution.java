package leetcode.p1662;
// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return concat(word1).equals(concat(word2));
    }

    private String concat(final String[] words) {
        StringBuilder sb= new StringBuilder();
        for (String word : words) sb.append(word);
        return sb.toString();
    }
}