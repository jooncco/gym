package leetcode.p34;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class Solution {
    private int n;
    private int[] notFound= {-1, -1};
    private int[] trivialSolution= {0, 0};

    public int[] searchRange(int[] nums, int target) {
        this.n= nums.length;
        if (n == 0) return notFound;
        if (n == 1) return nums[0] == target ? trivialSolution : notFound;

        // First index: normal binary search.
        int firstIdx= binarySearch(nums, target);
        if (nums[firstIdx] != target) return notFound;

        // Last index: find (target+1) and index--
        // Exception: if no (target+1) is found, index 'l' will be the last index (n-1).
        int lastIdx= binarySearch(nums, target+1);
        if (nums[lastIdx] != target+1) --lastIdx;

        int[] ans= { firstIdx, lastIdx };
        return ans;
    }

    private int binarySearch(final int[] nums, final int target) {
        int l= 0, r= n-1;
        while (l < r) {
            int m= l+(r-l)/2; // prevent integer overflow
            if (nums[m] < target) l= m+1;
            else r= m;
        }
        return l;
    }
}