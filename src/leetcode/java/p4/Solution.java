package leetcode.java.p4;
// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class Solution {
    private int m, n;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        int l = (m + n + 1) / 2, r = (m + n + 2) / 2;
        return (findKthValue(nums1, 0, nums2, 0, l) +
                findKthValue(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double findKthValue(final int[] nums1, int start1, final int[] nums2, int start2, int k) {
        if (start1 >= m)
            return nums2[start2 + k - 1];
        if (start2 >= n)
            return nums1[start1 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < m)
            mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < n)
            mid2 = nums2[start2 + k / 2 - 1];
        if (mid1 < mid2) {
            return findKthValue(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKthValue(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}