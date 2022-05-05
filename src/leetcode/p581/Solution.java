package leetcode.p581;
// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        return twoPointers(nums);
    }

    private int naiveSorting(int[] nums) {
        int n= nums.length;
        if (n == 1) return 0;
        int arr[]= nums.clone();
        Arrays.sort(arr);
        int l= -1, r= -1;
        for (int i=0; i < n; ++i) {
            if (arr[i] != nums[i]) {
                if (l == -1) l= i;
                r= i;
            }
        }
        return l >= 0 ? r-l+1 : 0;
    }

    private int twoPointers(int[] nums) {
        int n= nums.length;
        int l= -1, r= -2, maxFromLeft= nums[0], minFromRight= nums[n-1];
        for (int i=1; i < n; ++i) {
            if (nums[i] < maxFromLeft) r= i;
            if (nums[n-1-i] > minFromRight) l= n-1-i;
            maxFromLeft= Math.max(maxFromLeft, nums[i]);
            minFromRight= Math.min(minFromRight, nums[n-1-i]);
        }
        return r-l+1;
    }
}