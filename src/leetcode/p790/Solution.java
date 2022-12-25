package leetcode.p790;
// https://leetcode.com/problems/domino-and-tromino-tiling/

public class Solution {
    public int numTilings(int n) {
        final int MOD= 1000000007;
        int[] cache= new int[1001];
        cache[0]= cache[1]= 1;
        cache[2]= 2;
        for (int i=3; i <= n; ++i) {
            cache[i]= (cache[i-1] + cache[i-2])%MOD;
            for (int j=3; j <= i; ++j) {
                cache[i]= (cache[i] + 2*cache[i-j]%MOD)%MOD;
            }
        }
        return cache[n];
    }
}