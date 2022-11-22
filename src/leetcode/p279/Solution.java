package leetcode.p279;
// https://leetcode.com/problems/perfect-squares/

public class Solution {
    private int[] cache;

    public int numSquares(int n) {
        cache= new int[n+1];
        for (int i=0; i <= n; ++i) cache[i]= -1;
        return minNumOfSquares(n);
    }

    private int minNumOfSquares(int num) {
        if (num <= 1) return num;
        if (cache[num] > -1) return cache[num];

        cache[num]= num;
        for (int i=1; i*i <= num; ++i) {
            cache[num]= Math.min(cache[num], minNumOfSquares(num - i*i) + 1);
        }
        return cache[num];
    }
}