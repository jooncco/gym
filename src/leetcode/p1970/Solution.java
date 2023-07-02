package leetcode.p1970;
// https://leetcode.com/problems/last-day-where-you-can-still-cross/

/**
 * Disjoint Set
 * | Time: O (mn)
 * | Space: O (mn)
 */
public class Solution {
    public int latestDayToCross(int m, int n, int[][] cells) {
		int[][] D= {{-1,0}, {1,0}, {0,-1}, {0,1}};
		int[][] grid= new int[m][n];
        DisjointSet ds= new DisjointSet(m*n);
		for (int c=0; c < n-1; ++c) {
			ds.union(c, c+1);
			ds.union((m-1)*n + c, (m-1)*n + c+1);
		}
		for (int i=cells.length-1; i >= 0; --i) {
			int r= cells[i][0]-1, c= cells[i][1]-1;
			grid[r][c]= 1;
			int nr, nc;
			for (int[] d : D) {
				nr= r + d[0]; nc= c + d[1];
				if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
				if (grid[nr][nc] == 1) ds.union(nr*m + nc, r*m + c);
				if (ds.find(0) == ds.find((m-1)*n + n-1))
					return i;
			}

		}
		return 0;
    }

	private static class DisjointSet {
		int[] group;

		DisjointSet(int n) {
			group= new int[n];
			for (int i=0; i < n; ++i) {
				group[i]= i;
			}
		}

		int find(int idx) {
			if (group[idx] == idx) return idx;
			return group[idx]= find(group[idx]);
		}

		void union(int a, int b) {
			int groupA= find(a);
			int groupB= find(b);
			group[groupB]= groupA;
		}
	}
}