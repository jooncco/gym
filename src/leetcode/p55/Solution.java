package leetcode.p55;
// https://leetcode.com/problems/jump-game/

public class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int[] cache= new int[n];
        cache[0]= 1;
        for (int i=0; i < n-1; ++i) {
            if (cache[i] > 0) {
                int len= nums[i];
                for (int j=1; j <= Math.min(n-1, i+len); ++j) cache[j]= 1;
            }
        }
        return cache[n-1] == 1;
    }
}