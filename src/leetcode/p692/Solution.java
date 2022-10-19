package leetcode.p692;
// https://leetcode.com/problems/top-k-frequent-words/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> frequencyMap= new TreeMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Pair> pairs= new LinkedList<>();
        for (String key : frequencyMap.keySet()) {
            pairs.add(new Pair(key, frequencyMap.get(key)));
        }
        Collections.sort(pairs);

        List<String> ans= new LinkedList<>();
        for (int i=0; i < k; ++i) {
            ans.add(pairs.get(i).value);
        }
        return ans;
    }

    private static class Pair implements Comparable<Pair> {
        String value;
        int frequency;

        Pair(String value, int frequency) {
            this.value= value;
            this.frequency= frequency;
        }

        @Override
        public int compareTo(Pair there) {
            if (frequency == there.frequency) return value.compareTo(there.value);
            else return there.frequency - frequency;
        }
    }
}