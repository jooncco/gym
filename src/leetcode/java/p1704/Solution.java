package leetcode.java.p1704;
// https://leetcode.com/problems/determine-if-string-halves-are-alike/

import java.util.List;

/**
 * Brute Force
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public boolean halvesAreAlike(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (isVowel(s.charAt(i))) {
                cnt += i < s.length() / 2 ? 1 : -1;
            }
        }
        return cnt == 0;
    }

    private boolean isVowel(char c) {
        return List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c);
    }
}