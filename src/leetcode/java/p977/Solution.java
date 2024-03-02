package leetcode.java.p977;
// https://leetcode.com/problems/squares-of-a-sorted-array/

/**
 * Two pointers, Sortings
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        // Find zero or positive number
        int l = 0;
        while (nums[l] < 0 && l < n - 1) {
            ++l;
        }
        --l;
        int r = l + 1;

        // Two pointers
        int[] res = new int[n];
        int idx = 0;
        while (l >= 0 || r < n) {
            if (l < 0 || (r < n && nums[l] * nums[l] > nums[r] * nums[r])) {
                res[idx++] = nums[r] * nums[r];
                ++r;
            } else {
                res[idx++] = nums[l] * nums[l];
                --l;
            }
        }
        return res;
    }
}