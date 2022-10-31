package leetcode.p766;
// https://leetcode.com/problems/toeplitz-matrix/

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m= matrix.length, n= matrix[0].length;
        int r,c;
        for (int i=0; i < n-1; ++i) {
            r= 1; c= i+1;
            while (r < m && c < n) {
                if (matrix[r-1][c-1] != matrix[r][c]) return false;
                ++r; ++c;
            }
        }
        for (int i=0; i < n-1; ++i) {
            r= i+1; c= 1;
            while (r < m && c < n) {
                if (matrix[r-1][c-1] != matrix[r][c]) return false;
            }
        }
        return true;
    }
}