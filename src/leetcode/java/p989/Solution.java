package leetcode.java.p989;
// https://leetcode.com/problems/add-to-array-form-of-integer/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new LinkedList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0 || k > 0; --i) {
            int d = (i >= 0 ? num[i] : 0) + carry;
            if (k > 0) {
                d += k % 10;
                k /= 10;
            }
            if (d > 9) {
                carry = 1;
                d -= 10;
            } else
                carry = 0;
            ans.add(0, d);
        }
        if (carry > 0)
            ans.add(0, carry);
        return ans;
    }
}