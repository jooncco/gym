package leetcode.p1903;
// https://leetcode.com/problems/largest-odd-number-in-string/

/**
 * Greedy
 * | Time: O(len(num))
 * | Space: O(1)
 */
public class Solution {
    public String largestOddNumber(String num) {
        for (int r= num.length()-1; r >= 0; --r) {
            if ((num.charAt(r)-'0')%2 == 1) {
                return num.substring(0, r+1);
            }
        }
        return "";
    }
}