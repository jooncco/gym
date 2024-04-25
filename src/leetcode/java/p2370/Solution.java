package leetcode.java.p2370;
// https://leetcode.com/problems/longest-ideal-subsequence/

/**
 * Dynamic Programming (Bottom up)
 * Time: O(n*26)
 * Space: O(26) = O(1)
 */
public class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] cache = new int[26];
        for (int i = 0; i < n; ++i) {
            int charIdx = s.charAt(i) - 'a';
            int maxLen = 0;
            for (int j = 0; j < 26; ++j) {
                if (j < charIdx - k || j > charIdx + k)
                    continue;
                maxLen = Math.max(maxLen, cache[j] + 1);
            }
            cache[charIdx] = maxLen;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = Math.max(ans, cache[i]);
        }
        return ans;
    }
}