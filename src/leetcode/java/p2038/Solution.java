package leetcode.java.p2038;
// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

/**
 * Game Theory
 * | Time: O(|colors|)
 * | Space: O(1)
 */
public class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int a = 0, b = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                ++a;
            }
            if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                ++b;
            }
        }
        if (a == 0)
            return false;
        return a > b;
    }
}