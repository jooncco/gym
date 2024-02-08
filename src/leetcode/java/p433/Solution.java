package leetcode.java.p433;
// https://leetcode.com/problems/minimum-genetic-mutation/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (!List.of(bank).contains(end))
            return -1;

        Map<String, Integer> distance = new HashMap<>();
        List<String> paths = new LinkedList<>();
        distance.put(start, 0);
        paths.add(start);
        while (!paths.isEmpty()) {
            List<String> newPaths = new LinkedList<>();
            for (String path : paths) {
                if (path.equals(end))
                    return distance.get(path);

                for (String next : bank) {
                    if (isMutable(path, next) && !distance.containsKey(next)) {
                        distance.put(next, distance.get(path) + 1);
                        newPaths.add(next);
                    }
                }
            }
            paths = newPaths;
        }
        return -1;
    }

    private boolean isMutable(String from, String to) {
        int diff = 0;
        for (int i = 0; i < from.length(); ++i) {
            if (from.charAt(i) != to.charAt(i)) {
                ++diff;
            }
        }
        return diff == 1;
    }
}
