package leetcode.p718;
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

import java.util.Arrays;

public class Solution {
    private int m,n;
    private int[][] cache;

    public int findLength(int[] nums1, int[] nums2) {
        m= nums1.length; n= nums2.length;
        cache= new int[m][n];
        for (int i=0; i < m; ++i) Arrays.fill(cache[i], -1);
        int ans= 0;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                ans= Math.max(ans, maxLengthOfSubArray(nums1, nums2, i, j));
            }
        }
        return ans;
    }

    private int maxLengthOfSubArray(int[] nums1, int[] nums2, int l, int r) {
        if (l >= m || r >= n) return 0;
        if (nums1[l] != nums2[r]) return 0;

        if (cache[l][r] >= 0) return cache[l][r];
        cache[l][r]= 1 + maxLengthOfSubArray(nums1, nums2, l+1, r+1);
        return cache[l][r];
    }
}