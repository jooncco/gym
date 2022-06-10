package leetcode.p3;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int n, l, maxLen;
    private Set<Character> S;

    public int lengthOfLongestSubstring(String s) {
        n= s.length();
        if (n == 0) return 0;

        l= 0;
        S= new HashSet<>();
        S.add(s.charAt(0));
        maxLen= 1;
        for (int i=1; i < n; ++i) {
            char newChar= s.charAt(i);
            if (S.contains(newChar)) {
                while (l < i && s.charAt(l) != newChar) {
                    S.remove(s.charAt(l));
                    ++l;
                }
                ++l;
            } else {
                S.add(newChar);
            }
            maxLen= Math.max(maxLen, i-l+1);
        }
        return maxLen;
    }
}
