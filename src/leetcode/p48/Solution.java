package leetcode.p48;
// https://leetcode.com/problems/rotate-image/

public class Solution {
    private int n;
    public void rotate(int[][] matrix) {
        this.n = matrix.length;
        int len= n/2;
        if (n%2 == 1) ++len;
        for (int r=0; r < len; ++r) {
            int buf1, buf2;
            for (int c=r; c < n-1-r; ++c) {
                buf1= matrix[c][n-1-r];
                matrix[c][n-1-r]= matrix[r][c];

                buf2= matrix[n-1-r][n-1-c];
                matrix[n-1-r][n-1-c]= buf1;
                buf1= buf2;

                buf2= matrix[n-1-c][r];
                matrix[n-1-c][r]= buf1;
                buf1= buf2;

                matrix[r][c]= buf1;
            }
        }
    }
}