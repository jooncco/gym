package leetcode.java.p948;
// https://leetcode.com/problems/bag-of-tokens/

import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int initialPower) {
        Arrays.sort(tokens);
        int n = tokens.length, l = 0, r = n - 1;
        int maxScore = 0;
        while (l <= r) {
            if (tokens[l] > initialPower)
                break;
            int idx = l, score = 0, power = initialPower;
            while (idx <= r && tokens[idx] <= power) {
                power -= tokens[idx++];
                ++score;
            }
            maxScore = Math.max(maxScore, score);

            initialPower += (tokens[r] - tokens[l]);
            ++l;
            --r;
        }
        return maxScore;
    }
}