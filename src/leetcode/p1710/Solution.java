package leetcode.p1710;

import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n= boxTypes.length;
        // descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        // load
        int boxCnt= 0, ans= 0, idx= 0;
        while (boxCnt < truckSize && idx < n) {
            ++boxCnt;
            --boxTypes[idx][0];
            ans += boxTypes[idx][1];
            if (boxTypes[idx][0] == 0) ++idx;
        }
        return ans;
    }
}