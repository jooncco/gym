package leetcode.p290;
// https://leetcode.com/problems/word-pattern/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words= s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> patternMap= new HashMap<>();
        for (int i=0; i < words.length; ++i) {
            String matchedWord= patternMap.get(pattern.charAt(i));
            if (matchedWord != null && !words[i].equals(matchedWord)) return false;
            patternMap.put(pattern.charAt(i), words[i]);
        }
        Set<String> wordSet= new HashSet<>();
        for (String word : patternMap.values()) {
            if (wordSet.contains(word)) return false;
            wordSet.add(word);
        }
        return true;
    }
}