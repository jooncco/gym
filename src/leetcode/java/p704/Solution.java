package leetcode.java.p704;
// https://leetcode.com/problems/binary-search/description/

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return nums[l] == target ? l : -1;
    }
}