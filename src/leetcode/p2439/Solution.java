package leetcode.p2439;
// https://leetcode.com/problems/minimize-maximum-of-array/

public class Solution {
    public int minimizeArrayValue(int[] nums) {
        long cumSum= nums[0], curMax= nums[0];
        for (int i=1; i < nums.length; ++i) {
            cumSum += nums[i];
            if (curMax < nums[i]) {
                curMax= (cumSum+i)/(i+1);
            }
        }
        return (int)curMax;
    }
}