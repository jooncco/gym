package leetcode.p912;
// https://leetcode.com/problems/sort-an-array/

public class Solution {
    public int[] sortArray(int[] nums) {
        int[] arr= mergeSort(nums, 0, nums.length-1);
        return arr;
    }

    private int[] mergeSort(final int[] nums, int l, int r) {
        if (l == r) return new int[]{nums[l]};

        int m= l + (r-l)/2;
        int[] L= mergeSort(nums, l, m), R= mergeSort(nums, m+1, r);
        int[] ret= new int[r-l+1];
        int a= 0, b= 0, c= 0;
        while (a < L.length && b < R.length) {
            if (L[a] < R[b]) ret[c++]= L[a++];
            else ret[c++]= R[b++];
        }
        while (a < L.length) ret[c++]= L[a++];
        while (b < R.length) ret[c++]= R[b++];
        return ret;
    }
}