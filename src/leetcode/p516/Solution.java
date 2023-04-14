package leetcode.p516;
// https://leetcode.com/problems/longest-palindromic-subsequence/

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        int[][] cache= new int[n][n];

        for (int i=n-1; i >= 0; --i) {
            cache[i][i]= 1;
            for (int j=i+1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) cache[i][j]= 2 + cache[i+1][j-1];
                else cache[i][j]= Math.max(cache[i+1][j], cache[i][j-1]);
            }
        }
        return cache[0][n-1];
    }
}