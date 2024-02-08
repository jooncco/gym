package leetcode.java.p792;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int[] vector = new int[26];
        for (int i = 0; i < s.length(); ++i)
            ++vector[s.charAt(i) - 'a'];

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (String word : wordsMap.keySet()) {
            if (isSubsequence(s, vector, word))
                ans += wordsMap.get(word);
        }
        return ans;
    }

    private boolean isSubsequence(final String s, final int[] vector, final String word) {
        if (s.length() < word.length())
            return false;

        int[] wordVector = new int[26];
        for (int i = 0; i < word.length(); ++i)
            ++wordVector[word.charAt(i) - 'a'];
        for (int i = 0; i < 26; ++i) {
            if (vector[i] < wordVector[i])
                return false;
        }

        int wordIdx = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (wordIdx >= word.length())
                break;
            if (s.charAt(i) == word.charAt(wordIdx))
                ++wordIdx;
        }
        return wordIdx == word.length();
    }
}