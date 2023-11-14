package leetcode.p1930;
// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/

import java.util.*;

/**
 * DP
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int countPalindromicSubsequence(String s) {
        int n= s.length();
        int[] lCnt= new int[26], rCnt= new int[26];
        for (int i=n-1; i >= 1; --i) {
            ++rCnt[s.charAt(i)-'a'];
        }
        Set<String> uniquePalindromes= new HashSet<>();
        for (int i=1; i < n-1; ++i) {
            ++lCnt[s.charAt(i-1)-'a'];
            --rCnt[s.charAt(i)-'a'];
            for (int j=0; j < 26; ++j) {
                if (lCnt[j] > 0 && rCnt[j] > 0) {
                    uniquePalindromes.add("" + (char)('a'+j) + s.charAt(i) + (char)('a'+j));
                }
            }
        }
        return uniquePalindromes.size();
    }
}