package leetcode.java.p1688;
// https://leetcode.com/problems/count-of-matches-in-tournament/

/**
 * Math
 * | Time: O(log(n))
 * | Space: O(1)
 */
public class Solution {
    public int numberOfMatches(int n) {
        int matches = 0;
        while (n > 1) {
            matches += n >> 1;
            if ((n & 1) == 1)
                n = (n >> 1) + 1;
            else
                n >>= 1;
        }
        return matches;
    }
}