package leetcode.java.p13;

public class Solution {
    private int ans = 0;

    public int romanToInt(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char cur = s.charAt(i);
            char prev = i > 0 ? s.charAt(i - 1) : '.';

            if (cur == 'I')
                ans += 1;
            if (cur == 'V') {
                ans += 5;
                if (prev == 'I')
                    ans -= 2;
            }
            if (cur == 'X') {
                ans += 10;
                if (prev == 'I')
                    ans -= 2;
            }
            if (cur == 'L') {
                ans += 50;
                if (prev == 'X')
                    ans -= 20;
            }
            if (cur == 'C') {
                ans += 100;
                if (prev == 'X')
                    ans -= 20;
            }
            if (cur == 'D') {
                ans += 500;
                if (prev == 'C')
                    ans -= 200;
            }
            if (cur == 'M') {
                ans += 1000;
                if (prev == 'C')
                    ans -= 200;
            }
        }
        return ans;
    }
}