package leetcode.java.p609;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> path = new HashMap<>();
        for (String info : paths) {
            String[] str = info.split(" ");
            String dir = str[0];
            for (int i = 1; i < str.length; ++i) {
                String content = str[i].substring(str[i].indexOf("(") + 1, str[i].length() - 1);
                String fullPath = dir + str[i].substring(0, str[i].indexOf("("));
                List<String> fullPaths = path.getOrDefault(content, new LinkedList<>());
                fullPaths.add(fullPath);
                path.put(content, fullPaths);
            }
        }
        List<List<String>> ans = new LinkedList<>();
        for (String content : path.keySet()) {
            ans.add(path.get(content));
        }
        return ans;
    }
}