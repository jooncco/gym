package leetcode.java.lw-362. B;
// https://leetcode.com/contest/weekly-contest-362/problems/determine-if-a-cell-is-reachable-at-a-given-time/

/**
 * Greedy
 * | Time: O(1)
 * | Space: O(1)
 */
public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy)
            return t != 1;
        return t >= Math.max(Math.abs(fx - sx), Math.abs(fy - sy));
    }
}