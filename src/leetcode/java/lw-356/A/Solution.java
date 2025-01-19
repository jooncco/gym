package leetcode.java.lw-356. A;
// https://leetcode.com/contest/weekly-contest-356/problems/number-of-employees-who-met-the-target/

/**
 * Math (Simple Comparison)
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for (int hour : hours) {
            if (hour >= target)
                ++cnt;
        }
        return cnt;
    }
}