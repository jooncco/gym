package leetcode.java.p242;
// https://leetcode.com/problems/valid-anagram/

/**
 * Strings
 * | Time: O(n)
 * | Space: O(26)
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        // same length?
        int n = s.length(), m = t.length();
        if (n != m)
            return false;

        // populate char frequency vector
        int[] charFrequency = new int[26];
        for (int i = 0; i < n; ++i)
            ++charFrequency[s.charAt(i) - 'a'];

        // validate
        for (int i = 0; i < m; ++i) {
            --charFrequency[t.charAt(i) - 'a'];
            if (charFrequency[t.charAt(i) - 'a'] < 0)
                return false;
        }
        for (int i = 0; i < 26; ++i) {
            if (charFrequency[i] != 0)
                return false;
        }
        return true;
    }
}
