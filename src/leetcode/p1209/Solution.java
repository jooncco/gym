package leetcode.p1209;
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

import java.util.Stack;

public class Solution {
    Stack<Character> chars;
    Stack<Integer> counts;

    public String removeDuplicates(String s, int k) {
        int n= s.length();
        chars= new Stack<>();
        counts= new Stack<>();

        for (int i=0; i < n; ++i) {
            char c= s.charAt(i);
            if (!chars.isEmpty() && chars.peek() == c) {
                counts.push(counts.pop()+1);
                if (counts.peek() == k) {
                    chars.pop();
                    counts.pop();
                }
            }
            else {
                chars.push(c);
                counts.push(1);
            }
        }
        String ans= "";
        while (!chars.isEmpty()) {
            char c= chars.pop();
            int cnt= counts.pop();
            while (cnt-- > 0) {
                ans= c + ans;
            }
        }
        return ans;
    }
}