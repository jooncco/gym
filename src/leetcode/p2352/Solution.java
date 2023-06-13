package leetcode.p2352;

public class Solution {
    public int equalPairs(int[][] grid) {
		int n= grid.length, ans= 0;
		for (int r=0; r < n; ++r) {
			for (int c=0; c < n; ++c) {
				if (isEqual(grid, r, c)) ++ans;
			}
		}
		return ans;
    }

	private boolean isEqual(int[][] grid, int rIdx, int cIdx) {
		for (int i=0; i < grid.length; ++i) {
			if (grid[rIdx][i] != grid[i][cIdx]) return false;
		}
		return true;
	}
}