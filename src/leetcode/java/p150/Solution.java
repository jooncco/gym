package leetcode.java.p150;
// https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int a, b;
        for (String token : tokens) {
            if ("+".equals(token)) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(token)) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if ("/".equals(token)) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else if ("*".equals(token)) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a * b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}