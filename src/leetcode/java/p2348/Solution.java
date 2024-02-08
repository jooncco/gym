package leetcode.java.p2348;
// https://leetcode.com/problems/number-of-zero-filled-subarrays/

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, continued = 0;
        for (int num : nums) {
            if (num == 0)
                ans += ++continued;
            else
                continued = 0;
        }
        return ans;
    }
}