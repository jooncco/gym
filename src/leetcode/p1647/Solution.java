package leetcode.p1647;
// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

import java.util.*;

/**
 * Geedy, Sorting
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int minDeletions(String s) {
        int[] cnt= new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c-'a'];
        }
        Arrays.sort(cnt);
        int ans= 0;
        for (int i=25; i > 0; --i) {
            while (cnt[i] <= cnt[i-1] && cnt[i-1] > 0) {
                ++ans;
                --cnt[i-1];
            }
        }
        return ans;
    }
}