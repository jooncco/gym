package leetcode.p1332;
// https://leetcode.com/problems/remove-palindromeic-subsequences/

public class Solution {
    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }

    private boolean isPalindrome(String str) {
        int n= str.length();
        for (int i=0; i < n/2; ++i) {
            if (str.charAt(i) != str.charAt(n-1-i)) return false;
        }
        return true;
    }
}
