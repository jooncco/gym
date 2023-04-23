package leetcode.p1416;
// https://leetcode.com/problems/restore-the-array/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
	private int[] cache;
	private final int MOD= (int)1e9 + 7;

    public int numberOfArrays(String s, int k) {
        cache= new int[s.length()];
		for (int i=0; i < s.length(); ++i) cache[i]= -1;
		return numberOfArrays(s, k, 0);
    }

	private int numberOfArrays(String s, int k, int idx) {
		if (idx >= s.length()) return 1;
		if (s.charAt(idx) == '0') return 0;
		if (cache[idx] > -1) return cache[idx];

		cache[idx]= 0;
		int digits= 1;
		while (idx+digits <= s.length()) {
			long num= Long.parseLong(s.substring(idx, idx+digits));
			if (num > k) break;
			cache[idx]= add(cache[idx], numberOfArrays(s, k, idx+digits));
			++digits;
		}
		return cache[idx];
	}

	private int add(int a, int b) {
		return (a + b) % MOD;
	}
}