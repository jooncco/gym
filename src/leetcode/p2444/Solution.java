package leetcode.p2444;
// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/

public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int jMin= -1, jMax= -1, jBad= -1;
        long ans= 0;
        for (int i=0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) jBad= i;
            if (nums[i] == minK) jMin= i;
            if (nums[i] == maxK) jMax= i;
            ans += Math.max(0L, Math.min(jMin, jMax) - jBad);
        }
        return ans;
    }
}