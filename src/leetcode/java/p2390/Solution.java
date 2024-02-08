package leetcode.java.p2390;
// https://leetcode.com/problems/removing-stars-from-a-string/

import java.util.Stack;

public class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*')
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        return sb.toString();
    }
}