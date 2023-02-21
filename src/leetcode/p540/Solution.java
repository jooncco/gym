package leetcode.p540;
// https://leetcode.com/problems/single-element-in-a-sorted-array/

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l= 0, r= nums.length-1;
        while (l < r) {
            if ((l == 0 || nums[l] != nums[l-1]) && (nums[l] != nums[l+1] || l == nums.length-1))
                return nums[l];
            int m= l + (r-l)/2;
            if (isOnLeftSide(nums, m)) r= m;
            else l= m+1;
        }
        return nums[l];
    }

    private boolean isOnLeftSide(int[] nums, int m) {
        return !(m%2 == 1 && nums[m-1] == nums[m]) && !(m%2 == 0 && nums[m] == nums[m+1]);
    }
}
