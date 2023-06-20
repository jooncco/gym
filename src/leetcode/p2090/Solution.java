package leetcode.p2090;
// https://leetcode.com/problems/k-radius-subarray-averages/

/**
 * Sliding Window
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int[] getAverages(int[] A, int k) {
        int n= A.length;
        long sum= 0;
        for (int i=0; i < Math.min(i+k, n); ++i) {
            sum += A[i];
        }
        int[] ans= new int[n];
        for (int i=0; i < n; ++i) {
            if (i+k < n) sum += A[i+k];
            if (i-k > 0) sum -= A[i-k-1];
            if (i+k < n && i-k > -1) ans[i]= (int)(sum/(2*k+1));
            else ans[i]= -1;
        }
        return ans;
    }
}