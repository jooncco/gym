package leetcode.p70;
// https://leetcode.com/problems/climbing-stairs/

public class Solution {
    private int[] cache;

    public int climbStairs(int n) {
        preCalc(n);
        return cache[n];
    }

    private void preCalc(int n) {
        cache= new int[n+1];
        for (int i=1; i <= n; ++i) {
            if (i <= 2) cache[i]= i;
            else cache[i]= cache[i-1] + cache[i-2];
        }
    }
}