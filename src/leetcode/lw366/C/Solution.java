package leetcode.lw366.C;
// https://leetcode.com/contest/weekly-contest-366/problems/apply-operations-to-make-two-strings-equal/

import java.util.*;

/**
 * DP
 * | Time: O(|s1|)
 * | Space: O(2|s1|)
 */
public class Solution {
    private final int INF= 987654321;
    private int[][] cc;
    private int n, x;

    public int minOperations(String s1, String s2, int x) {
        char[] a1= s1.toCharArray(), a2= s2.toCharArray();
        this.n= a1.length;
        this.x= x;
        List<Integer> diffIdx= new ArrayList<>(n);
        for (int i= 0; i < n; ++i) {
            if (a1[i] != a2[i]) diffIdx.add(i);
        }
        cc= new int[diffIdx.size()][2];
        for (int i=0; i < diffIdx.size(); ++i) {
            for (int j= 0; j < 2; ++j) {
                cc[i][j]= -1;
            }
        }
        int ans= findMinCount(diffIdx, 0, 0);
        return ans == INF ? -1 : ans;
    }

    private int findMinCount(List<Integer> diffIdx, int cur, int carry) {
        if (cur == diffIdx.size()) {
            if (carry == 0) return 0;
            else return INF;
        }
        if (cc[cur][carry] > -1) return cc[cur][carry];

        cc[cur][carry]= INF;
        if (cur < diffIdx.size()-1) {
            int len= diffIdx.get(cur+1) - diffIdx.get(cur);
            cc[cur][carry]= Math.min(cc[cur][carry], len + findMinCount(diffIdx, cur+2, carry));
        }
        if (carry == 1) {
            cc[cur][carry]= Math.min(cc[cur][carry], findMinCount(diffIdx, cur+1, 0));
        } else {
            cc[cur][carry]= Math.min(cc[cur][carry], x + findMinCount(diffIdx, cur+1, 1));
        }
        return cc[cur][carry];
    }
}