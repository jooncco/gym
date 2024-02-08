package leetcode.java.p319;
// https://leetcode.com/problems/bulb-switcher/submissions/940396427/

/**
 * Math
 * | Time: O (log n)
 * | Space: O (1)
 */
public class Solution {
    public int bulbSwitch(int n) {
        int i = 1;
        while (i * i <= n)
            ++i;
        return i;
    }
}