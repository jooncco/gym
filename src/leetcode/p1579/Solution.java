package leetcode.p1579;
// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

import java.util.Arrays;

/**
 * Minimum Spanning Tree
 * | Time: O ( len(edges) )
 * | Space: O ( len(edges) )
 */
public class Solution {
	private static final int ALICE= 1;
	private static final int BOB= 2;
	private static final int BOTH= 3;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
		Arrays.sort(edges, (a,b) -> b[0]-a[0]);
		boolean[] alice= mst(n, edges, ALICE);
		boolean[] bob= mst(n, edges, BOB);
		int cntAlice= 0, cntBob= 0, total= 0;
		for (int i=0; i < alice.length; ++i) {
			if (alice[i]) ++cntAlice;
			if (bob[i]) ++cntBob;
			if (alice[i] || bob[i]) ++total;
		}
		if (cntAlice < n-1 || cntBob < n-1) return -1;
		return edges.length-total;
    }

	private boolean[] mst(int V, int[][] edges, int who) {
		boolean[] pickedEdge= new boolean[edges.length];
		UnionFind uf= new UnionFind(V+1);
		for (int i=0; i < edges.length; ++i) {
			int type= edges[i][0];
			if (type != BOTH && type != who) continue;
			if (!uf.union(edges[i][1], edges[i][2])) continue;
			pickedEdge[i]= true;
		}
		return pickedEdge;
	}

	private static class UnionFind {
		private int[] group;

		UnionFind(int n) {
			group= new int[n];
			for (int i=0; i < n; ++i) {
				group[i]= i;
			}
		}

		public int find(int idx) {
			if (group[idx] == idx) return idx;
			return group[idx]= find(group[idx]);
		}

		public boolean union(int a, int b) {
			int groupA= find(a);
			int groupB= find(b);
			if (groupA == groupB) return false;

			group[groupB]= groupA;
			return true;
		}
	}
}