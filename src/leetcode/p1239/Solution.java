package leetcode.p1239;
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

import java.util.List;

/**
 * Brute Force, Bitmask
 * | Time: O(2^n)
 * | Space: O(n)
 */
public class Solution {
    public int maxLength(List<String> arr) {
        arr= arr.stream().filter(str -> mask(str) != -1).toList();
        return maxLength(arr, 0, 0, 0);
    }

    private int mask(String str) {
        int res= 0;
        for (char c : str.toCharArray()) {
            int bit= 1 << (c - 'a');
            if ((res & bit) != 0) {
                return -1;
            }
            res |= bit;
        }
        return res;
    }

    private int maxLength(List<String> arr, int idx, int curMask, int curLen) {
        if (idx == arr.size()) return curLen;
        
        int ret= maxLength(arr, idx+1, curMask, curLen);
        if ((curMask & mask(arr.get(idx))) == 0) {
            ret= Math.max(ret, maxLength(arr, idx+1, curMask | mask(arr.get(idx)), curLen+arr.get(idx).length()));
        }
        return ret;
    }
}