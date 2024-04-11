package leetcode.java.p402;
// https://leetcode.com/problems/remove-k-digits/

/**
 * Stack
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        // Append to stack while popping larger digits
        for (char c : num.toCharArray()) {
            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) > c && k > 0) {
                --k;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
        }
        // Remove remaining k digits
        while (!sb.isEmpty() && k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            --k;
        }
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}