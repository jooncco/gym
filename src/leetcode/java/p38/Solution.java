package leetcode.java.p38;
// https://leetcode.com/problems/count-and-say

public class Solution {
    public String countAndSay(int n) {
        String cur = "1";
        while (--n > 0)
            cur = say(cur);
        return cur;
    }

    private String say(String digits) {
        StringBuilder sb = new StringBuilder();
        char curDigit = digits.charAt(0);
        int cnt = 1;
        for (int i = 1; i < digits.length(); ++i) {
            if (curDigit == digits.charAt(i))
                ++cnt;
            else {
                sb.append(cnt).append(curDigit);
                curDigit = digits.charAt(i);
                cnt = 1;
            }
        }
        sb.append(cnt).append(curDigit);
        return sb.toString();
    }
}