package leetcode.java.p1822;
// https://leetcode.com/problems/sign-of-the-product-of-an-array/

/**
 * Math
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0)
                ans = 0;
            if (num < 0)
                ans *= -1;
        }
        return ans;
    }
}