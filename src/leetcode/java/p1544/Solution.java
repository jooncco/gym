package leetcode.java.p1544;
// https://leetcode.com/problems/make-the-string-great/

/**
 * Stack
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!sb.isEmpty() && Math.abs(sb.charAt(sb.length() - 1) - c) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}