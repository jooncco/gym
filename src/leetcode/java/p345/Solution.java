package leetcode.java.p345;
// https://leetcode.com/problems/reverse-vowels-of-a-string/

import java.util.List;
import java.util.Stack;

public class Solution {
    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c))
                vowels.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c))
                sb.append(vowels.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(final char c) {
        return List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c);
    }
}
