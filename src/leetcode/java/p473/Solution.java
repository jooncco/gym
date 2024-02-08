package leetcode.java.p473;

import java.util.Arrays;

public class Solution {
    private int n;

    public boolean makesquare(int[] matchsticks) {
        this.n = matchsticks.length;
        int total = 0;
        for (final int match : matchsticks)
            total += match;
        if (total % 4 != 0)
            return false;

        Arrays.sort(matchsticks);
        int target = total / 4;
        return isPossible(matchsticks, 0, 0, 0, 0, n - 1, target);
    }

    private boolean isPossible(final int[] matchsticks, int top, int bottom, int left, int right, int idx, int target) {
        if (top > target || bottom > target || left > target || right > target)
            return false;
        if (idx < 0) {
            return top == bottom && bottom == right && right == left && left == target;
        }

        int match = matchsticks[idx];
        if (isPossible(matchsticks, top + match, bottom, left, right, idx - 1, target))
            return true;
        if (isPossible(matchsticks, top, bottom + match, left, right, idx - 1, target))
            return true;
        if (isPossible(matchsticks, top, bottom, left + match, right, idx - 1, target))
            return true;
        if (isPossible(matchsticks, top, bottom, left, right + match, idx - 1, target))
            return true;
        return false;
    }
}