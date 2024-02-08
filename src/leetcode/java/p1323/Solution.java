package leetcode.java.p1323;
// https://leetcode.com/problems/maximum-69-number/

public class Solution {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        int ans = 0, flag = 0;
        for (char c : str.toCharArray()) {
            if (c == '6') {
                ans += flag == 0 ? 9 : 6;
                flag = 1;
            } else
                ans += 9;
            ans *= 10;
        }
        return ans;
    }
}