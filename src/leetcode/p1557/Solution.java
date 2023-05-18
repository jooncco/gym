package leetcode.p1557;
// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> vertices= new HashSet<>();
        for (int i=0; i < n; ++i) vertices.add(i);
        for (List<Integer> edge : edges) {
            vertices.remove(edge.get(1));
        }
        return new ArrayList<>(vertices);
    }
}