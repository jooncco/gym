package leetcode.p844;

import java.util.Stack;

public class Solution {
    private Stack<Character> getResult(String s) {
        int n= s.length();
        Stack<Character> S= new Stack<>();
        for (int i=0; i < n; ++i) {
            if (s.charAt(i) == '#') {
                if (!S.isEmpty()) S.pop();
            }
            else S.push(s.charAt(i));
        }
        return S;
    }


    public boolean backspaceCompare(String s, String t) {
        int m= s.length(), n= t.length();
        Stack<Character> S= getResult(s);
        Stack<Character> T= getResult(t);
        if (S.size() != T.size()) return false;
        while (!S.empty()) {
            char c1= S.peek(), c2= T.peek();
            S.pop(); T.pop();
            if (c1 != c2) return false;
        }
        return true;
    }
}