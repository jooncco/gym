package leetcode.java.p1137;
// https://leetcode.com/problems/n-th-tribonacci-number/

/**
 * Dynamic Programming (Bottom up)
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n <= 2)
            return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; ++i) {
            int val = a + b + c;
            a = b;
            b = c;
            c = val;
        }
        return c;
    }
}