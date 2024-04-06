package leetcode.java.p1614;
// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

/**
 * Stack
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
            } else if (c == ')') {
                depth--;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}