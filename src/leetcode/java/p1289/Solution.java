package leetcode.java.p1289;
// https://leetcode.com/problems/minimum-falling-path-sum-ii/

/**
 * Dynamic Programming (Bottom up)
 * Time: O(n^2)
 * Space: O(n^2)
 */
public class Solution {
    private static final int INF = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] cache = new int[n][n];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                cache[r][c] = Integer.MAX_VALUE;
            }
        }

        for (int c = 0; c < n; ++c) {
            cache[0][c] = grid[0][c];
        }
        for (int r = 1; r < n; ++r) {
            int[] twoSmallestIndices = find2SmallestIndices(cache[r - 1]);
            for (int c = 0; c < n; ++c) {
                cache[r][c] = Math.min(
                        cache[r][c],
                        c == twoSmallestIndices[0]
                                ? cache[r - 1][twoSmallestIndices[1]] + grid[r][c]
                                : cache[r - 1][twoSmallestIndices[0]] + grid[r][c]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; ++c) {
            ans = Math.min(ans, cache[n - 1][c]);
        }
        return ans;
    }

    private int[] find2SmallestIndices(int[] row) {
        int smallest = INF, secondSmallest = INF;
        int smallestIdx = -1, secondSmallestIdx = -1;
        for (int i = 0; i < row.length; ++i) {
            if (secondSmallest > row[i]) {
                if (smallest > row[i]) {
                    secondSmallest = smallest;
                    secondSmallestIdx = smallestIdx;
                    smallest = row[i];
                    smallestIdx = i;
                } else {
                    secondSmallest = row[i];
                    secondSmallestIdx = i;
                }
            }
        }
        return new int[] { smallestIdx, secondSmallestIdx };
    }
}