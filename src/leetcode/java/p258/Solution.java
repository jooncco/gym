package leetcode.java.p258;
// https://leetcode.com/problems/add-digits/description/

/**
 * Math
 * | Time: O (log num)
 * | Space: O (1)
 */
public class Solution {
    public int addDigits(int num) {
        int ans = num;
        while (ans > 9) {
            int n = ans;
            ans = 0;
            while (n > 0) {
                ans += n % 10;
                n /= 10;
            }
        }
        return ans;
    }
}
