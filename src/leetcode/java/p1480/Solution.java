package leetcode.java.p1480;
// https://leetcode.com/problems/running-sum-of-1d-array/

public class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length, ans[] = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }
}