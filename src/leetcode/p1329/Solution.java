package leetcode.p1329;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int m, n;

    public int[][] diagonalSort(int[][] mat) {
        this.m = mat.length;
        this.n= mat[0].length;
        int r, c;
        for (int i=0; i < n; ++i) {
            r= 0; c= n-1-i;
            sortDiagonalArr(mat, r,c);
        }
        for (int i=0; i < m-1; ++i) {
            r= m-1-i; c= 0;
            sortDiagonalArr(mat, r,c);
        }
        return mat;
    }

    private void sortDiagonalArr(final int[][] mat, int r, int c) {
        List<Integer> diagonalArr = new ArrayList<>();
        int y= r, x= c;
        while (y < m && x < n) {
            diagonalArr.add(mat[y++][x++]);
        }
        diagonalArr.sort((a, b) -> a-b);
        y= r; x= c;
        while (y < m && x < n) {
            mat[y++][x++]= diagonalArr.remove(0);
        }
    }
}