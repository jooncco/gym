package leetcode.java.p916;
// https://leetcode.com/problems/word-subsets/submissions/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] filterVec = new int[26];
        for (String word : words2) {
            int[] vec = convertToFrequencyVec(word);
            for (int i = 0; i < 26; ++i) {
                filterVec[i] = Math.max(filterVec[i], vec[i]);
            }
        }

        List<String> ans = new LinkedList<>();
        for (String word : words1) {
            if (isUniversal(word, filterVec))
                ans.add(word);
        }
        return ans;
    }

    private boolean isUniversal(final String word, final int[] filter) {
        int[] freqVec = convertToFrequencyVec(word);
        for (int i = 0; i < 26; ++i) {
            if (freqVec[i] < filter[i])
                return false;
        }
        return true;
    }

    private int[] convertToFrequencyVec(final String word) {
        int[] vec = new int[26];
        for (final char c : word.toCharArray()) {
            ++vec[c - 'a'];
        }
        return vec;
    }
}