package leetcode.p1027;
// https://leetcode.com/problems/longest-arithmetic-subsequence/

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming (Bottom-up)
 * | Time: O (n^2)
 * | Space: O (n^2)
 */
public class Solution {
    public int longestArithSeqLength(int[] A) {
        int n= A.length;
        Map<Integer, Integer>[] cache= new HashMap[n];
        int ans= 2;
        for (int i=0; i < n; ++i) {
            cache[i]= new HashMap<>();
            for (int j=0; j < i; ++j) {
                int diff= A[i]-A[j];
                cache[i].put(diff, 1 + cache[j].getOrDefault(diff, 1));
                ans= Math.max(ans, cache[i].get(diff));
            }
        }
        return ans;
    }
}