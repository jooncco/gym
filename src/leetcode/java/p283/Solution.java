package leetcode.java.p283;
// https://leetcode.com/problems/move-zeroes/

/**
 * Two Pointers
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        int l= 0, r= 0;
        while (l < n || r < n) {
            while (l < n && nums[l] != 0) ++l;
            if (l == n) return;
            if (l > r) r= l;
            while (r < n && nums[r] == 0) ++r;
            if (r == n) return;
            swap(nums, l, r);
            ++l;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp= arr[i];
        arr[i]= arr[j];
        arr[j]= tmp;
    }
}