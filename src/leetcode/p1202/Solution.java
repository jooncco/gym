package leetcode.p1202;
// https://leetcode.com/problems/smallest-string-with-swaps/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    class UnionFind {
        private int group[], rank[];

        public UnionFind(int n) {
            group= new int[n];
            rank= new int[n];
            for (int i=0; i < n; ++i) group[i]= i;
        }

        public int find(int node) {
            if (group[node] != node) {
                group[node]= find(group[node]);
            }
            return group[node];
        }

        public void union(int node1, int node2) {
            int group1= find(node1);
            int group2= find(node2);

            if (group1 == group2) return;
            if (rank[group1] < rank[group2]) {
                group[group1]= group2;
            }
            else if (rank[group2] < rank[group1]) {
                group[group2]= group1;
            }
            else {
                group[group1]= group2;
                ++rank[group2];
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n= s.length();
        UnionFind uf= new UnionFind(n);

        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        List<List<Character>> groups= new ArrayList<>();
        for (int i=0; i < n; ++i) {
            groups.add(new LinkedList<>());
        }
        for (int i=0; i < n; ++i) {
            groups.get(uf.find(i)).add(s.charAt(i));
        }
        for (int i=0; i < n; ++i) {
            Collections.sort(groups.get(i));
        }
        String ans= "";
        for (int i=0; i < n; ++i) {
            ans += groups.get(uf.find(i)).get(0);
            groups.get(uf.find(i)).remove(0);
        }
        return ans;
    }
}