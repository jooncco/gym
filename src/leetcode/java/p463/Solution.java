package leetcode.java.p463;
// https://leetcode.com/problems/island-perimeter/

/**
 * Brute Force
 * Time: O(H*W), H=grid.length, W=grid[0].length
 * Space: O(1)
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        final int H = grid.length, W = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        ++perimeter;
                    if (i == H - 1 || grid[i + 1][j] == 0)
                        ++perimeter;
                    if (j == 0 || grid[i][j - 1] == 0)
                        ++perimeter;
                    if (j == W - 1 || grid[i][j + 1] == 0)
                        ++perimeter;
                }
            }
        }
        return perimeter;
    }
}
