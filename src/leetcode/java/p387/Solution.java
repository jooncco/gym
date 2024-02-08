package leetcode.java.p387;

import java.util.Arrays;

public class Solution {
    private int[] frequency, firstOccurredAt;

    public int firstUniqChar(String s) {
        frequency = new int[26];
        firstOccurredAt = new int[26];
        Arrays.fill(firstOccurredAt, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            frequency[idx]++;
            firstOccurredAt[idx] = Math.min(firstOccurredAt[idx], i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {
            if (frequency[i] == 1) {
                ans = Math.min(ans, firstOccurredAt[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}