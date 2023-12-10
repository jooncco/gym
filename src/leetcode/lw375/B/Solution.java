package leetcode.lw375.B;
// https://leetcode.com/contest/weekly-contest-375/problems/double-modular-exponentiation/

import java.util.*;

/**
 * Math
 * | Time: O(nbc)
 * | Space: O(n)
 */
public class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            int a = v[0], b = v[1], c = v[2], d = v[3];
            int val = 1;
            for (int j = 0; j < b; ++j) {
                val = (val * a) % 10;
            }
            int tmp = 1;
            for (int j = 0; j < c; ++j) {
                tmp = (tmp * val) % d;
            }
            if (target == tmp)
                ret.add(i);
        }
        return ret;
    }
}