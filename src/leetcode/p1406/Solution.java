package leetcode.p1406;
// https://leetcode.com/problems/stone-game-iii/

/**
 * Dynamic Programming (Bottom-up)
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n= stoneValue.length;
        int[] suffixSum= new int[n+1];
        int[] cache= new int[n+1];
        suffixSum[n]= 0;
        cache[n]= 0;
        for (int i= n-1; i >= 0; --i) {
            suffixSum[i] = suffixSum[i + 1] + stoneValue[i];
        }
        for (int i = n-1; i >= 0; i--) {
            cache[i] = stoneValue[i] + suffixSum[i+1] - cache[i+1];
            for (int k = i+1; k < Math.min(i+3, n); k++) {
                cache[i] = Math.max(cache[i], suffixSum[i]-cache[k+1]);
            }
        }
        return cache[0]*2 == suffixSum[0]
		        ? "Tie"
		        : cache[0]*2 > suffixSum[0]
		            ? "Alice"
		            : "Bob";
    }
}