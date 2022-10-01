package leetcode.p91;
// https://leetcode.com/problems/decode-ways/

import java.util.Arrays;

public class Solution {
    private int n;
    private int[] cache;

    public int numDecodings(String s) {
        if (s.isEmpty()) return 0;

        char[] arr= s.toCharArray();
        cache= new int[n= arr.length];
        Arrays.fill(cache, -1);
        return countWays(arr, 0);
    }

    private int countWays(final char[] arr, int idx) {
        if (idx >= n) return 1;
        if (arr[idx] == '0') return 0;
        if (cache[idx] > -1) return cache[idx];

        cache[idx]= 0;
        if (idx < n-1) {
            int twoDigits= Integer.parseInt(""+arr[idx]+arr[idx+1]);
            if (twoDigits > 0 && twoDigits < 27) cache[idx] += countWays(arr, idx+2);
        }
        int oneDigit= arr[idx]-'0';
        if (oneDigit > 0 && oneDigit < 10) cache[idx] += countWays(arr, idx+1);
        return cache[idx];
    }
}