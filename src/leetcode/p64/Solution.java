package leetcode.p64;
// https://leetcode.com/problems/minimum-path-sum/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int[][] cache= new int[m][n];
        cache[0][0]= grid[0][0];
        for (int i=1; i < n; ++i) cache[0][i]= cache[0][i-1] + grid[0][i];
        for (int i=1; i < m; ++i) cache[i][0]= cache[i-1][0] + grid[i][0];
        for (int i=1; i < m; ++i) {
            for (int j=1; j < n; ++j) {
                cache[i][j]= Math.min(cache[i][j-1], cache[i-1][j]) + grid[i][j];
            }
        }
        return cache[m-1][n-1];
    }
}