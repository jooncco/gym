package leetcode.p91;
// https://leetcode.com/problems/decode-ways/

/**
 * DP (Top-down)
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    private String str;
    private int[] cache;

    public int numDecodings(String s) {
        str= s;
        cache= new int[s.length()];
        for (int i=0; i < s.length(); ++i) {
            cache[i]= -1;
        }
        return numDecodings(0);
    }

    private int numDecodings(int idx) {
        if (idx >= str.length()) return 1;
        if (cache[idx] != -1) return cache[idx];

        cache[idx]= 0;
        int oneDigit= Integer.parseInt(str.substring(idx, idx+1));
        if (oneDigit > 0 && oneDigit < 10) {
            cache[idx] += numDecodings(idx+1);
        }
        if (idx < str.length()-1) {
            int twoDigits= Integer.parseInt(str.substring(idx, idx+2));
            if (twoDigits > 9 && twoDigits < 27) {
                cache[idx] += numDecodings(idx+2);
            }
        }
        return cache[idx];
    }
}