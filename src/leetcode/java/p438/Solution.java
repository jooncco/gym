package leetcode.java.p438;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int n;
    private int[] cnt;

    public List<Integer> findAnagrams(String s, String p) {
        n = p.length();
        cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - n; ++i) {
            if (isAnagram(s.substring(i, i + n))) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isAnagram(String str) {
        int here[] = new int[26];
        for (char c : str.toCharArray()) {
            here[c - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != here[i])
                return false;
        }
        return true;
    }
}