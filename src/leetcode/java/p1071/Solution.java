package leetcode.java.p1071;
// https://leetcode.com/problems/greatest-common-divisor-of-strings/

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length())
            return gcdOfStrings(str2, str1);
        String ret = "";
        for (int i = 0; i < str2.length(); ++i) {
            for (int j = i + 1; j <= str2.length(); ++j) {
                if (j - i < ret.length())
                    continue;
                String candidate = str2.substring(i, j);
                if (isDivisible(str1, candidate) && isDivisible(str2, candidate))
                    ret = candidate;
            }
        }
        return ret;
    }

    private boolean isDivisible(String dividend, String divisor) {
        return dividend.equals(divisor.repeat(dividend.length() / divisor.length()));
    }
}