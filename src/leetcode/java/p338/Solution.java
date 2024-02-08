package leetcode.java.p338;
// https://leetcode.com/problems/counting-bits/

/**
 * Implementation
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            ans[i] = bitCount(i);
        return ans;
    }

    private int bitCount(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 2;
            num /= 2;
        }
        return cnt;
    }
}