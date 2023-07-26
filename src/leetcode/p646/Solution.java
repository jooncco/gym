package leetcode.p646;
// https://leetcode.com/problems/maximum-length-of-pair-chain/

import java.util.Arrays;

/**
 * Dynamic Programming
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[0] == b[0]
                ? Integer.compare(a[1],b[1])
                : Integer.compare(a[0],b[0]));
        int n= pairs.length;
        int[] cache= new int[n];
        for (int i=0; i < n; ++i) cache[i]= 1;
        int ans= 1;
        for (int i=1; i < n; ++i) {
            for (int j=0; j < i; ++j) {
                if (pairs[i][0] > pairs[j][1]) {
                    cache[i]= Math.max(cache[i], cache[j]+1);
                }
            }
            ans= Math.max(ans, cache[i]);
        }
        return ans;
    }
}