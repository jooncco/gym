package leetcode.java.p1456;
// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

import java.util.List;

/**
 * Sliding Window
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int maxVowels(String s, int k) {
        int vowels = 0;
        for (int i = 0; i < k; ++i) {
            if (isVowel(s.charAt(i)))
                ++vowels;
        }
        int ans = vowels;
        for (int i = k; i < s.length(); ++i) {
            if (isVowel(s.charAt(i)))
                ++vowels;
            if (isVowel(s.charAt(i - k)))
                --vowels;
            ans = Math.max(ans, vowels);
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return List.of('a', 'e', 'i', 'o', 'u').contains(c);
    }
}