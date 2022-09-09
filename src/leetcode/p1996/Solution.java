package leetcode.p1996;
// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

import java.util.Arrays;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        final int n= properties.length;
        int ans= 0, curDefMax= 0;
        Arrays.sort(properties, (a,b) -> a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]);
        for (int i=n-1; i >= 0; --i) {
            if (properties[i][1] < curDefMax) ++ans;
            curDefMax= Math.max(curDefMax, properties[i][1]);
        }
        return ans;
    }
}