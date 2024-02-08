package leetcode.java.p2264;
// https://leetcode.com/problems/largest-3-same-digit-number-in-string/

/**
 * String
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for (int i = 2; i < num.length(); ++i) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2)) {
                if ("".equals(ans) || ans.charAt(0) < num.charAt(i - 2)) {
                    ans = num.substring(i - 2, i + 1);
                }
            }
        }
        return ans;
    }
}