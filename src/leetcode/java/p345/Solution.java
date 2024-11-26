package leetcode.java.p345;
// https://leetcode.com/problems/reverse-vowels-of-a-string/

import java.util.*;

/**
 * Stack
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack= new Stack<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                stack.push(c);
            }
        }
        StringBuilder sb= new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c); 
    }
}
