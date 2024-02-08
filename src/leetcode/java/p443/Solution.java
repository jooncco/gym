package leetcode.java.p443;
// https://leetcode.com/problems/string-compression/

import java.util.Stack;

public class Solution {
    private char[] chars;
    private char curr;
    private int cnt, idx;

    public int compress(char[] chars) {
        this.chars = chars;
        curr = chars[0];
        cnt = 1;
        idx = 0;
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == curr)
                ++cnt;
            else {
                write();
                curr = chars[i];
                cnt = 1;
            }
        }
        write();
        return idx;
    }

    private void write() {
        chars[idx++] = curr;
        if (cnt > 1) {
            Stack<Character> stack = new Stack<>();
            while (cnt > 0) {
                stack.push((char) ('0' + cnt % 10));
                cnt /= 10;
            }
            while (!stack.isEmpty()) {
                chars[idx++] = stack.pop();
            }
        }
    }
}