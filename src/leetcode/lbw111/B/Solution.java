package leetcode.lb111.B;
// https://leetcode.com/contest/biweekly-contest-111/problems/make-string-a-subsequence-using-cyclic-increments/

/**
 * Greedy
 * | Time: O (m + n)
 * | Space: O (1)
 */
public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n= str1.length();
        int idx= 0;
        for (int i=0; i < n; ++i) {
            if (idx == str2.length()) return true;
            if (str1.charAt(i) == str2.charAt(idx)) ++idx;
            else if (str1.charAt(i) == 'z' && str2.charAt(idx) == 'a') ++idx;
            else if (str1.charAt(i)-'a'+1 == str2.charAt(idx)-'a') ++idx;
        }
        return idx == str2.length();
    }
}