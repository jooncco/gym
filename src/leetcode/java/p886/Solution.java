package leetcode.java.p886;
// https://leetcode.com/problems/possible-bipartition/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // reconstruct
        Map<Integer, List<Integer>> dislikeOfMember = new HashMap<>();
        for (int[] dislike : dislikes) {
            dislikeOfMember.computeIfAbsent(dislike[0], key -> new LinkedList<>()).add(dislike[1]);
        }
        // union-find
        DisjointSet disjointSet = new DisjointSet(n);
        for (int member : dislikeOfMember.keySet()) {
            List<Integer> dislikedMembers = dislikeOfMember.get(member);
            for (int dislikedMember : dislikedMembers) {
                if (disjointSet.find(member) == disjointSet.find(dislikedMember))
                    return false;
            }
            for (int i = 0; i < dislikedMembers.size(); ++i) {
                for (int j = i + 1; j < dislikedMembers.size(); ++j) {
                    disjointSet.union(dislikedMembers.get(i), dislikedMembers.get(j));
                }
            }
        }
        return true;
    }

    static class DisjointSet {
        /**
         * This class implements union-find algorithm.
         * Omitted rank field for simplicity.
         */
        int[] group;

        DisjointSet(int n) {
            group = new int[n + 1];
            for (int i = 1; i <= n; ++i) {
                group[i] = i;
            }
        }

        int find(int i) {
            if (group[i] == i)
                return i;
            return group[i] = find(group[i]);
        }

        void union(int a, int b) {
            int groupA = find(a), groupB = find(b);
            group[b] = groupA;
        }
    }
}