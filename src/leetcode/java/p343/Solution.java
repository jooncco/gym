package leetcode.java.p343;
// https://leetcode.com/problems/integer-break/

/**
 * Math (Number Theory)
 * | Time: O(n^2)
 * | Space: O(1)
 */
public class Solution {
    public int integerBreak(int n) {
        int ans = 0;
        for (int k = 2; k <= n; ++k) {
            int d = n / k;
            int prd = 1;
            for (int i = 0; i < k - n % k; ++i)
                prd *= d;
            for (int i = 0; i < n % k; ++i)
                prd *= (d + 1);
            ans = Math.max(ans, prd);
        }
        return ans;
    }
}