package leetcode.p1328;
// https://leetcode.com/problems/break-a-palindrome/

public class Solution {
    public String breakPalindrome(String p) {
        if (p.length() == 1) return "";
        for (int i=0; i < p.length()/2; ++i) {
            if (p.charAt(i) > 'a') {
                return p.substring(0, i) + "a" + p.substring(i+1);
            }
        }
        return p.substring(0, p.length()-1) + "b";
    }
}
