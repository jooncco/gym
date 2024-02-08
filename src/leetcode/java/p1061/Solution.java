package leetcode.java.p1061;
// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

public class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        DisjointSet dj = new DisjointSet();
        for (int i = 0; i < n; ++i) {
            dj.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (dj.find(c - 'a') + 'a'));
        }
        return sb.toString();
    }

    private class DisjointSet {
        int[] group, rank;

        DisjointSet() {
            group = new int[26];
            rank = new int[26];
            for (int i = 0; i < 26; ++i) {
                group[i] = rank[i] = i;
            }
        }

        int find(int idx) {
            if (group[idx] == idx)
                return group[idx];
            return group[idx] = find(group[idx]);
        }

        void union(int a, int b) {
            if (find(a) == find(b))
                return;
            int groupA = find(a), groupB = find(b);
            if (rank[groupA] < rank[groupB]) {
                group[groupB] = groupA;
            } else {
                group[groupA] = groupB;
            }
        }
    }
}