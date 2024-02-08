package leetcode.java.p2225;
// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.*;

/**
 * Brute Force
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] wins = new int[100010], loses = new int[100010];
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            ++wins[winner];
            ++loses[loser];
        }
        List<Integer> zero = new ArrayList<>(), one = new ArrayList<>();
        for (int i = 0; i <= 100000; ++i) {
            if (wins[i] > 0 && loses[i] == 0)
                zero.add(i);
            if (wins[i] > 0 && loses[i] == 1)
                one.add(i);
        }
        return List.of(zero, one);
    }
}