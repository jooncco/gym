package leetcode.java.p2706;
// https://leetcode.com/problems/buy-two-chocolates/

/**
 * Sortings
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int buyChoco(int[] prices, int money) {
        int mn1 = 101, mn2 = 102;
        for (int price : prices) {
            if (price < mn2) {
                if (price < mn1) {
                    mn2 = mn1;
                    mn1 = price;
                } else {
                    mn2 = price;
                }
            }
        }
        return mn1 + mn2 <= money ? money - mn1 - mn2 : money;
    }
}