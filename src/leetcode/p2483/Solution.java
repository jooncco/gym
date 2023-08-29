package leetcode.p2483;
// https://leetcode.com/problems/minimum-penalty-for-a-shop/

/**
 * DP
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int bestClosingTime(String customers) {
        int n= customers.length();
        int[] N= new int[n+1], Y= new int[n+1];
        for (int i=0; i < n; ++i) {
            if (customers.charAt(i) == 'N') N[i]= 1;
            if (customers.charAt(i) == 'Y') Y[i]= 1;
        }
        for (int i=1; i <= n; ++i) N[i] += N[i-1];
        for (int i=n-1; i >= 0; --i) Y[i] += Y[i+1];
        int mn= N[n-1], idx= n;
        for (int i=n-1; i >= 0; --i) {
            int val= Y[i];
            if (i > 0) val += N[i-1];
            if (mn >= val) {
                mn= val;
                idx= i;
            }
        }
        return idx;
    }
}