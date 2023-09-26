package leetcode.p316;
// https://leetcode.com/problems/remove-duplicate-letters/

import java.util.*;

/**
 * Monotone Stack
 * | Time: O(|s|)
 * | Space: O(1)
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt= new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c-'a'];
        }
        Stack<Character> stack= new Stack<>();
        boolean[] exist= new boolean[26];
        for (char c : s.toCharArray()) {
            if (exist[c-'a']) {
                --cnt[c-'a'];
                continue;
            }
            while (!stack.isEmpty() &&
                stack.peek() >= c &&
                cnt[stack.peek()-'a'] > 1) {
                char poppedC= stack.pop();
                --cnt[poppedC-'a'];
                exist[poppedC-'a']= false;
            }
            stack.push(c);
            exist[c-'a']= true;
        }
        StringBuilder sb= new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}