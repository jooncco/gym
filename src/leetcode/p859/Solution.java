package leetcode.p859;
// https://leetcode.com/problems/buddy-strings/

/**
 * Ad hoc
 * | Time: O (n + m)
 * | Space: O (1)
 */
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] chars= new int[26];
            for (char c : s.toCharArray()) {
                ++chars[c-'a'];
                if (chars[c-'a'] > 1) return true;
            }
        }
        int cnt= 0, idxA= 0, idxB= 0;
        for (int i=0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                ++cnt;
                if (cnt == 1) idxA= i;
                if (cnt == 2) idxB= i;
            }
        }
        if (cnt == 2 &&
                s.charAt(idxA) == goal.charAt(idxB) &&
                s.charAt(idxB) == goal.charAt(idxA)) {
            return true;
        }
        return false;
    }
}