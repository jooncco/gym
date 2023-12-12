package leetcode.p1464;
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

/**
 * Sortings
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int m1= -1, m2= -1;
        for (int i= 0; i < nums.length; ++i) {
            if (m2 < nums[i]) {
                if (m1 < nums[i]) {
                    m2= m1;
                    m1= nums[i];
                } else {
                    m2= nums[i];
                }
            }
        }
        return (m1-1)*(m2-1);
    }
}