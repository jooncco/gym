package leetcode.p2246;
// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private int ans= 1;
    private Map<Integer, Set<Integer>> children= new HashMap<>();

    public int longestPath(int[] parent, String s) {
        // reconstruct
        for (int i=1; i < parent.length; ++i) {
            children.computeIfAbsent(parent[i], childrenSet -> new HashSet<>()).add(i);
        }

        // compute
        findLongest(0, s);
        return ans;
    }

    private int findLongest(int here, String s) {
        if (!children.containsKey(here)) return 1;

        Queue<Integer> childLengths= new PriorityQueue<>((a,b) -> Integer.compare(b,a)); // descending order
        for (int child : children.get(here)) {
            int childLength= findLongest(child, s);
            if (s.charAt(child) == s.charAt(here)) continue;
            childLengths.add(childLength);
        }
        if (childLengths.isEmpty()) return 1;
        int longest= childLengths.poll();
        if (!childLengths.isEmpty()) {
            int secondLongest= childLengths.poll();
            ans= Math.max(ans, longest + secondLongest + 1);
        }
        ans= Math.max(ans, longest+1);
        return longest+1;
    }
}