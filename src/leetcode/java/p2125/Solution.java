package leetcode.java.p2125;
// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

/**
 * Brute Force
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, ans = 0;
        for (int i = 0; i < bank.length; ++i) {
            int cur = 0;
            for (char c : bank[i].toCharArray()) {
                if (c == '1')
                    ++cur;
            }
            if (cur > 0) {
                ans += prev * cur;
                prev = cur;
            }
        }
        return ans;
    }
}