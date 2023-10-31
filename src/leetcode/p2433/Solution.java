package leetcode.p2433;
// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/

/**
 * Math
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int[] findArray(int[] pref) {
        int n= pref.length;
        int[] arr= new int[n];
        arr[0]= pref[0];
        for (int i=1; i < n; ++i) {
            arr[i]= pref[i-1]^pref[i];
        }
        return arr;
    }
}