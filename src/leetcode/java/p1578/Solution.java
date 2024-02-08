package leetcode.java.p1578;
// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

/**
 * Greedy
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans = 0, maxTime = neededTime[0];
        for (int i = 1; i < n; ++i) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                if (maxTime < neededTime[i]) {
                    ans += maxTime;
                    maxTime = neededTime[i];
                } else {
                    ans += neededTime[i];
                }
            } else {
                maxTime = neededTime[i];
            }
        }
        return ans;
    }
}