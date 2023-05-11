package leetcode.p1035;
// https://leetcode.com/problems/uncrossed-lines/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (mn)
 * | Space: O (mn)
 */
public class Solution {
    private int m, n;
    private int[][] cache;

    public int maxUncrossedLines(int[] A, int[] B) {
        m= A.length;
        n= B.length;
        cache= new int[m][n];
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                cache[i][j]= -1;
            }
        }
        findMax(A, B, 0, 0);
        return cache[0][0];
    }

    private int findMax(int[] A, int[] B, int l, int r) {
        if (l == m || r == n) return 0;
        if (cache[l][r] > -1) return cache[l][r];

        if (A[l] == B[r]) cache[l][r]= 1 + findMax(A, B, l+1, r+1);
        else cache[l][r]= Math.max(findMax(A, B, l+1, r), findMax(A, B, l, r+1));
        return cache[l][r];
    }
}