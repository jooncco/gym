package leetcode.p1624;
// https://leetcode.com/problems/largest-substring-between-two-equal-characters/

/**
 * DP (Bottom-up)
 * | Time: O(|s|)
 * | Space: O(26)
 */
public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] idx= new int[26];
        for (int i=0; i < 26; ++i) idx[i]= -1;
        int ans= -1;
        for (int i= 0; i < s.length(); ++i) {
            if (idx[s.charAt(i)-'a'] != -1) {
                ans= Math.max(ans, i-idx[s.charAt(i)-'a']-1);
            }
            if (idx[s.charAt(i)-'a'] == -1) idx[s.charAt(i)-'a']= i;
        }
        return ans;
    }
}