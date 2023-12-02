package leetcode.p1160;
// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

/**
 * Strings, Implementation
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cnt= new int[26];
        for (char c : chars.toCharArray()) {
            ++cnt[c-'a'];
        }
        int ans= 0;
        for (String word : words) {
            int[] curWordCnt= new int[26];
            for (char c : word.toCharArray()) {
                ++curWordCnt[c-'a'];
            }
            boolean good= true;
            for (int i= 0; i < curWordCnt.length; ++i) {
                if (curWordCnt[i] > cnt[i]) good= false;
            }
            if (good) ans += word.length();
        }
        return ans;
    }
}
