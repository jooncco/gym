package leetcode.java.p1897;
// https://leetcode.com/problems/largest-substring-between-two-equal-characters/

/**
 * Math
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] cnt = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] % n != 0)
                return false;
        }
        return true;
    }
}
