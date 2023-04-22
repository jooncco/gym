package leetcode.p1312;
// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

/**
 * Dynamic Programming (Bottom-up), Longest Common Subsequence
 * | Time: O (n^2)
 * | Space: O (n^2)
 */
public class Solution {
    public int minInsertions(String s) {
	    return s.length()-lcs(s, (new StringBuilder(s)).reverse().toString());
    }

	private int lcs(String a, String b) {
		int m= a.length(), n= a.length();
		int[][] cache= new int[m+1][n+1];
		for (int i=0; i < m ; ++i) {
			for (int j=0; j < n; ++j) {
				cache[i+1][j+1]= a.charAt(i) == b.charAt(j)
						? cache[i][j]+1
						: Math.max(cache[i][j+1], cache[i+1][j]);
			}
		}
		return cache[m][n];
	}
}