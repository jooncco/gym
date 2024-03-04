package leetcode.java.p948;
// https://leetcode.com/problems/bag-of-tokens/

import java.util.Arrays;

/**
 * Greedy
 * Time: O(nlogn)
 * Space: O(1)
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int score = 0, maxScore = 0;
        while (l <= r) {
            // Earn max score
            while (l <= r && power >= tokens[l]) {
                power -= tokens[l++];
                ++score;
            }
            maxScore = Math.max(score, maxScore);

            // Trade score with token with max power
            if (score == 0)
                break;
            power += tokens[r--];
            --score;
        }
        return maxScore;
    }
}