package leetcode.lw373.D;
// https://leetcode.com/contest/weekly-contest-373/problems/count-beautiful-substrings-ii/

import java.util.*;

/**
 * DP(Bottom-up), Math
 * | Time: O(n^2/len)
 * | Space: O(n)
 */
public class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n= s.length();
        int[] vowelsSoFar= new int[n+1];
        for (int i=1; i <= n; ++i) {
            vowelsSoFar[i]= vowelsSoFar[i-1];
            if (isVowel(s.charAt(i-1))) ++vowelsSoFar[i];
        }

        int len= 2;
        while (len/2*len/2%k != 0) len += 2;
        int[] cnt= new int[n+1];
        int ans= 0;
        for (int i=2; i <= n; ++i) {
            if (i < len) continue;
            int curLen= len;
            while (curLen <= i) {
                int vowels= vowelsSoFar[i]-vowelsSoFar[i-curLen];
                if (vowels == curLen/2) {
                    cnt[i] += 1 + cnt[i-curLen];
                    break;
                }
                curLen += len;
            }
            ans += cnt[i];
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return List.of('a', 'e', 'i', 'o', 'u').contains(c);
    }
}