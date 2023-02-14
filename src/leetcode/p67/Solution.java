package leetcode.p67;
// https://leetcode.com/problems/add-binary/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result= new StringBuilder();
        int m= a.length(), n= b.length();
        int carry= 0;
        for (int i=0; i < Math.max(m,n); ++i) {
            int d= carry;
            if (i < m) d += a.charAt(m-1-i)-'0';
            if (i < n) d += b.charAt(n-1-i)-'0';
            if (d > 1) {
                carry= 1;
                d -= 2;
            } else carry= 0;
            result.append(d);
        }
        if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }
}