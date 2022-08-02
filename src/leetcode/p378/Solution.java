package leetcode.p378;
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

public class Solution {
    private int n;

    public int kthSmallest(int[][] matrix, int k) {
        this.n= matrix.length;

        // binary search
        int low= matrix[0][0];      // min
        int high= matrix[n-1][n-1]; // max
        while (low < high) {
            int mid= low + (high-low)/2; // avoid integer overflow

            int count= lessThanOrEqualToValues(matrix, mid);
            if (count < k) low= mid+1;
            else high= mid;
        }
        return low;
    }

    private int lessThanOrEqualToValues(final int[][] matrix, int value) {
        int r= n-1, c= 0;
        int cnt= 0;
        while (r >= 0 && c < n) {
            if (matrix[r][c] > value) --r;
            else {
                cnt += r+1;
                ++c;
            }
        }
        return cnt;
    }
}