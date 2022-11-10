package leetcode.p1047;
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

import java.util.Stack;
public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack= new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        StringBuilder sb= new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}