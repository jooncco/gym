package leetcode.p1544;
// https://leetcode.com/problems/make-the-string-great/

public class Solution {
    private StringBuilder sb;

    public String makeGood(String s) {
        sb= new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0 || goodToAppend(c)) sb.append(c);
            else sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private boolean goodToAppend(char c) {
        return Math.abs(sb.charAt(sb.length()-1) - c) != 32;
    }
}