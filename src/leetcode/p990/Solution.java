package leetcode.p990;
// https://leetcode.com/problems/satisfiability-of-equality-equations/

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();
        for (final String equation : equations) {
            int a= equation.charAt(0)-'a', b= equation.charAt(3)-'a';
            if (equation.charAt(1) == '=') unionFind.union(a,b);
        }

        for (final String equation : equations) {
            int a= equation.charAt(0)-'a', b= equation.charAt(3)-'a';
            if (equation.charAt(1) == '!') {
                if (!unionFind.isDisjoint(a,b)) return false;
            }
        }
        return true;
    }

    private class UnionFind {
        private int group[];

        private UnionFind() {
            group= new int[26];
            for (int i=0; i < group.length; ++i) group[i]= i;
        }

        private int find(int idx) {
            if (group[idx] == idx) return idx;
            return group[idx]= find(group[idx]);
        }

        private void union(int a, int b) {
            int aRoot= find(a), bRoot= find(b);
            group[aRoot]= bRoot;
        }

        private boolean isDisjoint(int a, int b) {
            return find(a) != find(b);
        }
    }
}