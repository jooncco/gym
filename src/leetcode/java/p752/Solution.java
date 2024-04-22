package leetcode.java.p752;
// https://leetcode.com/problems/open-the-lock/

import java.util.*;

/**
 * BFS
 * Time: O(10000) = O(1)
 * Space: O(10000) = O(1)
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        // Init deadends set
        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        // Run BFS
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        for (int i = 0; i < 10000; ++i) {
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return i;
                }
                if (deadendSet.contains(current)) {
                    continue;
                }
                for (int d = 0; d < 4; ++d) {
                    int digit = current.charAt(d) - '0';
                    String up = current.substring(0, d) + (digit + 1) % 10 + current.substring(d + 1);
                    String down = current.substring(0, d) + (digit + 9) % 10 + current.substring(d + 1);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
        }
        return -1;
    }
}
