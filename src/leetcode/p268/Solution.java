package leetcode.p268;
// https://leetcode.com/problems/missing-number/

public class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length, sum= n*(n+1)/2;
        for (int num : nums) sum -= num;
        return sum;
    }
}