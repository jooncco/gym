package leetcode.java.p1249;
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

/**
 * Stack
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        // Validate given string.
        // Add closing parentheses to removeIdx if the stack is empty.
        Set<Integer> removeIdx = new HashSet<>();
        Stack<Integer> openParentheses = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (openParentheses.isEmpty()) {
                    removeIdx.add(i);
                } else {
                    openParentheses.pop();
                }
            } else if (s.charAt(i) == '(') {
                openParentheses.add(i);
            }
        }
        // Add remaining open indices to removeIdx
        while (!openParentheses.isEmpty()) {
            removeIdx.add(openParentheses.pop());
        }
        // Build a string with characters whose index is not in removeIdx
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (!removeIdx.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}