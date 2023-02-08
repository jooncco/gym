package leetcode.p45;
// https://leetcode.com/problems/jump-game-ii/

public class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int[] minJumps= new int[n];
        for (int i=1; i < n; ++i) minJumps[i]= Integer.MAX_VALUE;
        for (int i=0; i < n-1; ++i) {
            for (int j=0; j <= nums[i]; ++j) {
                if (i+j >= n) break;
                minJumps[i+j]= Math.min(minJumps[i+j], minJumps[i]+1);
            }
        }
        return minJumps[n-1];
    }
}