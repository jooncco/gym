package leetcode.p1732;
// https://leetcode.com/problems/find-the-highest-altitude/

/**
 * Math
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int largestAltitude(int[] gain) {
        int ans= 0, altitude= 0;
        for (int i=0; i < gain.length; ++i) {
            altitude += gain[i];
            ans= Math.max(ans, altitude);
        }
        return ans;
    }
}