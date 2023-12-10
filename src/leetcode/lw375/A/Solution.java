package leetcode.lw375.A;
// https://leetcode.com/contest/weekly-contest-375/problems/count-tested-devices-after-test-operations/

/**
 * Implementation
 * | Time: O(n^2)
 * | Space: O(1)
 */
public class Solution {
    public int countTestedDevices(int[] battery) {
        int n = battery.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (battery[i] > 0) {
                ++ans;
                for (int j = i + 1; j < n; ++j) {
                    battery[j] = Math.max(0, battery[j] - 1);
                }
            }
        }
        return ans;
    }
}