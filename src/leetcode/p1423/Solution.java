package leetcode.p1423;

import java.util.Arrays;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        final int n= cardPoints.length, windowLen= n- k;
        int sum= 0;
        for (int i=0; i < windowLen; ++i) sum += cardPoints[i];
        int ans= sum;
        for (int i=windowLen; i < n; ++i) {
            sum += cardPoints[i];
            sum -= cardPoints[i-windowLen];
            ans= Math.min(ans, sum);
        }
        return Arrays.stream(cardPoints).sum() - ans;
    }
}