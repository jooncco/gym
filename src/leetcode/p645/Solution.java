package leetcode.p645;
// https://leetcode.com/problems/set-mismatch/

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n= nums.length;
        boolean[] isExist= new boolean[n+1];
        int dup= -1;
        for (int num : nums) {
            if (isExist[num]) dup= num;
            isExist[num]= true;
        }
        int miss= -1;
        for (int num=1; num <= n; ++num) {
            if (!isExist[num]) {
                miss= num;
                break;
            }
        }
        return new int[]{dup, miss};
    }
}