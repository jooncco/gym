package leetcode.p867;
// https://leetcode.com/problems/transpose-matrix/

public class Solution {
    public int[][] transpose(int[][] matrix) {
        int n= matrix.length, m= matrix[0].length;
        int trans[][]= new int[m][n];
        for (int i=0; i < n; ++i) {
            for (int j=0; j < m; ++j) {
                trans[j][i]= matrix[i][j];
            }
        }
        return trans;
    }
}
