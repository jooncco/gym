package leetcode.p26;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int idx= 1, writeIdx= 0;
        while (idx < nums.length) {
            if (nums[idx] > nums[writeIdx]) {
                nums[++writeIdx] = nums[idx];
            }
            ++idx;
        }
        return writeIdx+1;
    }
}