package leetcode.lw373.B;
// https://leetcode.com/contest/weekly-contest-373/problems/count-beautiful-substrings-i/

/**
 * Brute Force
 * | Time: O(|s|^2)
 * | Space: O(1)
 */
public class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n= s.length();
        int ans= 0;
        for (int i= 0; i < n; ++i) {
            int vowel= 0, consonant= 0;
            for (int j= i; j < n; ++j) {
                if (isVowel(s.charAt(j))) ++vowel;
                else ++consonant;
                if (vowel != consonant) continue;
                if (vowel*consonant%k == 0) ++ans;
            }
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }
}