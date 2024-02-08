package leetcode.java.p2305;
// https://leetcode.com/problems/fair-distribution-of-cookies/

/**
 * Depth First Search
 * | Time: O (k^n)
 * | Space: O (k+n)
 */
public class Solution {
	private int ans = (int) 1e6;

	public int distributeCookies(int[] A, int k) {
		dfs(A, 0, new int[k]);
		return ans;
	}

	private void dfs(int[] A, int idx, int[] children) {
		if (idx == A.length) {
			int unfairness = 0;
			for (int child : children)
				unfairness = Math.max(unfairness, child);
			ans = Math.min(ans, unfairness);
			return;
		}

		for (int i = 0; i < children.length; ++i) {
			children[i] += A[idx];
			dfs(A, idx + 1, children);
			children[i] -= A[idx];
		}
	}
}