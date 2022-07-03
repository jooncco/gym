package leetcode.p376;

public class Solution {
    private int[][] cache;

    public int wiggleMaxLength(int[] nums) {
        int n= nums.length;
        cache= new int[n][2];
        return Math.max(findMaxLength(nums, 0, 0), findMaxLength(nums, 0, 1));
    }

    private int findMaxLength(final int[] nums, final int idx, final int isUp) {
        int n= nums.length;
        if (n == idx) return 0;

        if (cache[idx][isUp] > 0) return cache[idx][isUp];

        cache[idx][isUp]= 1;
        for (int i=idx+1; i < n; ++i) {
            if (isUp == 1 && nums[i] < nums[idx]) {
                cache[idx][isUp]= Math.max(cache[idx][isUp], 1+findMaxLength(nums, i, 0));
            }
            if (isUp == 0 && nums[i] > nums[idx]) {
                cache[idx][isUp]= Math.max(cache[idx][isUp], 1+findMaxLength(nums, i, 1));
            }
        }
        return cache[idx][isUp];
    }
}
