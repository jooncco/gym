package leetcode.java.p238;
// https://leetcode.com/problems/product-of-array-except-self/

/**
 * Array
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] p= new int[n], s= new int[n];
        p[0]= nums[0];
        for (int i=1; i < n; ++i) {
            p[i]= p[i-1]*nums[i];
        }
        s[n-1]= nums[n-1];
        for (int i=n-2; i >= 0; --i) {
            s[i]= s[i+1]*nums[i];
        }
        int[] ans= new int[n];
        for (int i=0; i < n; ++i) {
            int mul= 1;
            if (i > 0) mul *= p[i-1];
            if (i < n-1) mul *= s[i+1];
            ans[i]= mul;
        }
        return ans;
    }
}