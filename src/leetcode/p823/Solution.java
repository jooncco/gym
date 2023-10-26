package leetcode.p823;
// https://leetcode.com/problems/binary-trees-with-factors/

import java.util.*;

/**
 * Math (Number Theroy)
 * | Time: O(n^2 log(n))
 * | Space: O(n)
 */
public class Solution {
    private final static int MOD= (int)1e9 + 7;
    private Map<Integer, Integer> cc;

    public int numFactoredBinaryTrees(int[] arr) {
        cc= new HashMap<>();
        Arrays.sort(arr); // O(n log(n))
        int ans= 0;
        for (int divisor : arr) { // O(n^2 log(n))
            ans= (ans+howMany(arr, divisor))%MOD;
        }
        return ans;
    }

    // O(n log(n))
    private int howMany(int[] arr, int dividend) {
        if (cc.containsKey(dividend)) return cc.get(dividend); // O(1)
        long ret= 1;
        for (int divisor : arr) { // O(n log(n))
            if (dividend%divisor == 0 && isExist(arr, dividend/divisor)) { // O(log(n))
                long left= howMany(arr, divisor);
                long right= howMany(arr, dividend/divisor);
                ret= (ret + (left*right)%MOD)%MOD;
            }
        }
        cc.put(dividend, (int)ret);
        return (int)ret;
    }

    // O(log(n))
    private boolean isExist(int[] arr, int target) {
        int l= 0, r= arr.length-1;
        while (l < r) {
            int m= (l+r)/2;
            if (arr[m] < target) l= m+1;
            else r= m;
        }
        return arr[l] == target;
    }
}