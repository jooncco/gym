package leetcode.p240;
// https://leetcode.com/problems/search-a-2d-matrix-ii/

public class Solution {
    private int m,n;
    private boolean[][] visited;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.m= matrix.length;
        this.n= matrix[0].length;
        visited= new boolean[m][n];
        visited[0][0]= true;
        return findTarget(matrix, 0, 0, target);
    }

    private boolean findTarget(final int[][] matrix, final int r, final int c, final int target) {
        if (matrix[r][c] == target) return true;

        boolean found= false;
        if (matrix[r][c] > target) {
            if (r > 0 && !visited[r-1][c]) {
                visited[r-1][c]= true;
                if (findTarget(matrix, r-1, c, target)) found= true;
            }
            if (c > 0 && !visited[r][c-1]) {
                visited[r][c-1]= true;
                if (findTarget(matrix, r, c-1, target)) found= true;
            }
        }
        if (matrix[r][c] < target) {
            if (r < m-1 && !visited[r+1][c]) {
                visited[r+1][c]= true;
                if (findTarget(matrix, r+1, c, target)) found= true;
            }
            if (c < n-1 && !visited[r][c+1]) {
                visited[r][c+1]= true;
                if (findTarget(matrix, r, c+1, target)) found= true;
            }
        }
        return found;
    }
}