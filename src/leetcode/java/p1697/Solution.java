package leetcode.java.p1697;
// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

import java.util.Arrays;

/**
 * Union Find
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
	public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
		for (int i = 0; i < queries.length; ++i) {
			queries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
		}
		Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
		Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
		UnionFind uf = new UnionFind(n);
		boolean[] ans = new boolean[queries.length];
		int edgeIdx = 0;
		for (int[] query : queries) {
			int from = query[0], to = query[1];
			int limit = query[2];
			while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
				uf.union(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
				++edgeIdx;
			}
			ans[query[3]] = uf.find(from) == uf.find(to);
		}
		return ans;
	}

	private static class UnionFind {
		private int[] group;

		UnionFind(int n) {
			group = new int[n];
			for (int i = 0; i < n; ++i)
				group[i] = i;
		}

		public int find(int idx) {
			if (group[idx] == idx)
				return idx;
			return group[idx] = find(group[idx]);
		}

		public void union(int a, int b) {
			int groupA = find(a), groupB = find(b);
			if (groupA == groupB)
				return;
			group[groupB] = groupA;
		}
	}
}