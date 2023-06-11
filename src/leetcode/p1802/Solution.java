package leetcode.p1802;
// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

/**
 * Binary Search
 * | Time: O (log (maxSum))
 * | Space: O (1)
 */
public class Solution {
	public int maxValue(int n, int index, int maxSum) {
		int l= 1, r= maxSum;
		while (l < r) {
			int m= (l+r)/2;
			if (isPossible(n, index, maxSum, m)) l= m+1;
			else r= m;
		}
		return isPossible(n, index, maxSum, l) ? l : l-1;
	}

	private boolean isPossible(int n, int index, int maxSum, long val) {
		long sum= val*(val+1)/2 + val*(val-1)/2;
		long left= val-1-index;
		if (left > 0) sum -= left*(left+1)/2;
		if (left < 0) sum -= left;
		long right= val-1-(n-1-index);
		if (right > 0) sum -= right*(right+1)/2;
		if (right < 0) sum -= right;
		return sum <= maxSum;
	}
}