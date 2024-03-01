package leetcode.java.p2864;
// https://leetcode.com/problems/maximum-odd-binary-number/

/**
 * Greedy
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int ones = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1')
                ++ones;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; ++i) {
            sb.append(ones-- > 0 ? '1' : '0');
        }
        sb.append('1');
        return sb.toString();
    }
}