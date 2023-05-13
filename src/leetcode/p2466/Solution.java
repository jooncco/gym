package leetcode.p2466;

public class Solution {
	private int[] cache;
	private int low, high, zero, one;
	private final int MOD= (int)1e9 + 7;

	public int countGoodStrings(int low, int high, int zero, int one) {
		this.low= low;
		this.high= high;
		this.zero= zero;
		this.one= one;
		cache= new int[high];
		for (int i=0; i < high; ++i) cache[i]= -1;
		return findCount(0);
	}

	private int findCount(int cur) {
		if (cur + zero > high && cur + one > high) return cur >= low ? 1 : 0;
		if (cache[cur] > -1) return cache[cur];

		cache[cur]= 0;
		if (cur >= low) cache[cur]= 1;
		if (cur + zero <= high) cache[cur]= (cache[cur] + findCount(cur + zero)) % MOD;
		if (cur + one <= high) cache[cur]= (cache[cur] + findCount(cur + one)) % MOD;
		return cache[cur];
	}
}