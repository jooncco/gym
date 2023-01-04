package leetcode.p2520;
// https://leetcode.com/problems/count-the-digits-that-divide-a-number/

public class Solution {
    public int countDigits(int num) {
        int digits= num, ans= 0;
        while (digits > 0) {
            int digit= digits%10;
            if (num%digit == 0) ++ans;
            digits /= 10;
        }
        return ans;
    }
}