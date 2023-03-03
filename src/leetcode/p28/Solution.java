package leetcode.p28;
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int n= needle.length();
        for (int i=0; i <= haystack.length()-n; ++i) {
            if (haystack.substring(i, i+n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}