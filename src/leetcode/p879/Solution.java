package leetcode.p879;
// https://leetcode.com/problems/profitable-schemes/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (n * minProfit * group.length)
 * | Space: O (n * minProfit * group.length)
 */
public class Solution {
	private int numOfCrimes;
	private int[][][] cache;
	private int[] group, profit;
	private final int MOD= (int)1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		this.group= group;
		this.profit= profit;
		numOfCrimes= group.length;
        cache= new int[n+1][numOfCrimes][minProfit+1];
		for (int i=0; i <= n; ++i) {
			for (int j=0; j < numOfCrimes; ++j) {
				for (int k=0; k <= minProfit; ++k) {
					cache[i][j][k]= -1;
				}
			}
		}
		return findNumberOfSchemes(n, 0, minProfit);
	}

	private int findNumberOfSchemes(int members, int idx, int profitNeeded) {
		if (idx >= numOfCrimes || members == 0) {
			return profitNeeded <= 0 ? 1 : 0;
		}
		profitNeeded= Math.max(profitNeeded, 0);
		if (cache[members][idx][profitNeeded] > -1) return cache[members][idx][profitNeeded];

		cache[members][idx][profitNeeded]= 0;
		cache[members][idx][profitNeeded]=
				add(cache[members][idx][profitNeeded], findNumberOfSchemes(members, idx+1, profitNeeded));
		if (group[idx] <= members) {
			cache[members][idx][profitNeeded]=
					add(cache[members][idx][profitNeeded],
						findNumberOfSchemes(members-group[idx], idx+1, profitNeeded-profit[idx]));
		}
		return cache[members][idx][profitNeeded];
	}

	private int add(int a, int b) {
		return (a + b) % MOD;
	}
}