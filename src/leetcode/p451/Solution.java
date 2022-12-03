package leetcode.p451;
// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> occurrence= new HashMap<>();
        for (char c : s.toCharArray()) {
            occurrence.put(c, occurrence.getOrDefault(c, 0)+1);
        }
        List<WordChunk> wordChunks= new LinkedList<>();
        for (char c : occurrence.keySet()) {
            wordChunks.add(new WordChunk(c, occurrence.get(c)));
        }
        wordChunks.sort((a,b) -> b.cnt - a.cnt);
        StringBuilder sb= new StringBuilder();
        for (WordChunk wc : wordChunks) {
            for (int i=0; i < wc.cnt; ++i) sb.append(wc.c);
        }
        return sb.toString();
    }

    private static class WordChunk {
        char c;
        int cnt;

        WordChunk(char c, int cnt) {
            this.c= c;
            this.cnt= cnt;
        }
    }
}