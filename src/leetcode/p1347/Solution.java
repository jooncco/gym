package leetcode.p1347;

/**
 * Math
 * | Time: O(|s|)
 * | Space: O(26)
 */
public class Solution {
    public int minSteps(String s, String t) {
        int[] cnt= new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c-'a'];
        }
        for (char c : t.toCharArray()) {
            --cnt[c-'a'];
        }
        int ans= 0;
        for (int i=0; i < 26; ++i) {
            if (cnt[i] > 0) ans += cnt[i];
            if (cnt[i] < 0) ans -= cnt[i]; 
        }
        return ans/2;
    }
}
