package leetcode.p1704;
// https://leetcode.com/problems/determine-if-string-halves-are-alike/

import java.util.List;
public class Solution {
    public boolean halvesAreAlike(String s) {
        int cntA= 0, cntB= 0;
        for (int i=0; i < s.length(); ++i) {
            if (isVowel(s.charAt(i))) {
                if (s.length()/2 > i) ++cntA;
                else ++cntB;
            }
        }
        return cntA == cntB;
    }

    private boolean isVowel(char c) {
        return List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c);
    }
}