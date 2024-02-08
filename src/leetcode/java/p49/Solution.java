package leetcode.java.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);

            List<String> group = groups.getOrDefault(key, new LinkedList<>());
            group.add(str);
            groups.put(key, group);
        }
        return new ArrayList<>(groups.values());
    }

    private String getKey(final String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        StringBuilder sb = new StringBuilder();
        for (char c : charArray)
            sb.append(c);
        return sb.toString();
    }
}