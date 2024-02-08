package leetcode.java.p5;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxIdx = 0, maxLen = 1;
        for (int i = 1; i < n; ++i) {
            if (i - maxLen >= 0 && isPalindrome(s.substring(i - maxLen, i + 1))) {
                maxIdx = i - maxLen;
                maxLen = maxLen + 1;
            }
            if (i - maxLen - 1 >= 0 && isPalindrome(s.substring(i - maxLen - 1, i + 1))) {
                maxIdx = i - maxLen - 1;
                maxLen = maxLen + 2;
            }
        }
        return s.substring(maxIdx, maxIdx + maxLen);
    }

    private boolean isPalindrome(final String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; ++i) {
            if (str.charAt(i) != str.charAt(n - 1 - i))
                return false;
        }
        return true;
    }
}