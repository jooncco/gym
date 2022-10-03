package leetcode.p1578;
// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n= colors.length();
        int ans= 0, l= 0, r= 0, maxVal= neededTime[0];
        List<Integer> times= new LinkedList<>();
        times.add(neededTime[0]);
        for (int i=1; i < n; ++i) {
            if (colors.charAt(i) != colors.charAt(i-1)) {
                if (l < r) {
                    ans += times.stream().reduce(0, Integer::sum);
                    ans -= maxVal;
                }
                l= r= i;
                maxVal= neededTime[i];
                times= new LinkedList<>();
                times.add(neededTime[i]);
            } else {
                ++r;
                times.add(neededTime[i]);
                maxVal= Math.max(maxVal, neededTime[i]);
            }
        }
        if (l < r) {
            ans += times.stream().reduce(0, Integer::sum);
            ans -= maxVal;
        }
        return ans;
    }
}