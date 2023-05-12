package leetcode.p2140;
// https://leetcode.com/problems/solving-questions-with-brainpower/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
	private int n;
	private long[] cache;

    public long mostPoints(int[][] questions) {
		n= questions.length;
		cache= new long[n];
		for (int i=0; i < n; ++i) cache[i]= -1;
		return findMax(questions, 0);
    }

	private long findMax(int[][] questions, int idx) {
		if (idx == n) return 0;
		if (cache[idx] > -1) return cache[idx];

		cache[idx]= Math.max(questions[idx][0] + 0L, findMax(questions, idx+1));
		if (idx + questions[idx][1] + 1 <= n) {
			cache[idx]= Math.max(
					cache[idx],
					questions[idx][0] + findMax(questions, idx + questions[idx][1] + 1));
		}
		return cache[idx];
	}
}