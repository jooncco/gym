package leetcode.p905;
// https://leetcode.com/problems/sort-array-by-parity/

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n= nums.length;
        int ans[]= new int[n];
        int idx= 0;
        for (int i=0; i < n; ++i) {
            if (nums[i]%2 == 0) ans[idx++]= nums[i];
        }
        for (int i=0; i < n; ++i) {
            if (nums[i]%2 == 1) ans[idx++]= nums[i];
        }
        return ans;
    }
}
