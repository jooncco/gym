package leetcode.java.p839;
// https://leetcode.com/problems/similar-string-groups/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Disjoint set
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    private List<Set<String>> groups = new ArrayList<>();

    public int numSimilarGroups(String[] strs) {
        for (String str : strs) {
            List<Integer> similarGroups = new ArrayList<>();
            for (int i = 0; i < groups.size(); ++i) {
                Set<String> group = groups.get(i);
                for (String word : group) {
                    if (isSimilar(str, word)) {
                        similarGroups.add(i);
                        break;
                    }
                }
            }
            if (similarGroups.isEmpty()) {
                Set<String> newGroup = new HashSet<>();
                newGroup.add(str);
                groups.add(newGroup);
            } else {
                groups.get(similarGroups.get(0)).add(str);
            }
            if (similarGroups.size() >= 2) {
                mergeGroups(similarGroups);
            }
        }
        return groups.size();
    }

    private void mergeGroups(List<Integer> indices) {
        Set<String> newGroup = new HashSet<>();
        for (int index : indices) {
            newGroup.addAll(groups.get(index));
        }
        List<Set<String>> newGroups = new ArrayList<>();
        for (int i = 0; i < groups.size(); ++i) {
            if (indices.contains(i))
                continue;
            newGroups.add(groups.get(i));
        }
        newGroups.add(newGroup);
        groups = newGroups;
    }

    private boolean isSimilar(String a, String b) {
        if (a.length() != b.length())
            return false;
        List<Integer> diffIdx = new ArrayList<>();
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                diffIdx.add(i);
            }
        }
        return diffIdx.isEmpty() || (diffIdx.size() == 2
                && a.charAt(diffIdx.get(0)) == b.charAt(diffIdx.get(1))
                && a.charAt(diffIdx.get(1)) == b.charAt(diffIdx.get(0)));
    }
}