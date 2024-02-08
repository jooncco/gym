package leetcode.java.p7;
// https://leetcode.com/problems/reverse-integer/

public class Solution {
    public int reverse(int x) {
        String strX = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if (strX.charAt(0) == '-') {
            sb.append('-');
            strX = strX.substring(1);
        }
        for (int i = strX.length() - 1; i >= 0; --i)
            sb.append(strX.charAt(i));
        int ret;
        try {
            ret = Integer.parseInt(sb.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
        return ret;
    }
}