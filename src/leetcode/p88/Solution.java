package leetcode.p88;
// https://leetcode.com/problems/merge-sorted-array/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] buf= new int[m];
        for (int i=0; i < m; ++i) buf[i]= nums1[i];
        int i= 0, j= 0, k= 0;
        while (i < m && j < n) {
            if (buf[i] >= nums2[j]) nums1[k++]= nums2[j++];
            else nums1[k++]= buf[i++];
        }
        while (i < m) nums1[k++]= buf[i++];
        while (j < n) nums1[k++]= nums2[j++];
    }
}