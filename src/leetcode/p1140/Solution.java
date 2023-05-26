package leetcode.p1140;
// https://leetcode.com/problems/stone-game-ii/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (nm)
 * | Space: O (nm)
 */
public class Solution {
	private int n;
	private int[][] cache;
	private int[] cumSum;

    public int stoneGameII(int[] piles) {
		init(piles);
		return findMax(piles, 0, 1);
    }

	private void init(int[] piles) {
		n= piles.length;
        cache= new int[n][101];
		for (int i=0; i < n; ++i) {
			for (int j=0; j < 101; ++j) {
				cache[i][j]= -1;
			}
		}
		cumSum= new int[n];
		cumSum[n-1]= piles[n-1];
		for (int i=n-2; i >= 0; --i) {
			cumSum[i]= cumSum[i+1] + piles[i];
	    }
	}

	private int findMax(int[] piles, int idx, int m) {
		if (idx >= n) return 0;
		if (idx + 2*m >= n) return cumSum[idx];
		if (cache[idx][m] > -1) return cache[idx][m];

		cache[idx][m]= 0;
		for (int i=0; i <= Math.min(n-idx, 2*m-1); ++i) {
			cache[idx][m]= Math.max(
					cache[idx][m],
					cumSum[idx] - findMax(piles, idx+i+1, Math.max(m, i+1)));
		}
		return cache[idx][m];
	}
}