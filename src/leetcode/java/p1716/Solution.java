package leetcode.java.p1716;
// https://leetcode.com/problems/calculate-money-in-leetcode-bank/

/**
 * Math
 * | Time: O(n/7)
 * | Space: O(1)
 */
public class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int firstDay = 1;
        while (n >= 7) {
            n -= 7;
            ans += (2 * firstDay + 6) * 7 / 2;
            ++firstDay;
        }
        return ans + (2 * firstDay + (n - 1)) * n / 2;
    }
}