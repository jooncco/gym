package leetcode.p2171;

import java.util.Arrays;

public class Solution {
    public long minimumRemoval(int[] beans) {
        int n= beans.length;
        if (n == 1) return 0;

        long totalSum = Arrays.stream(beans).mapToLong(x->x).sum();
        Arrays.sort(beans);
        long ans= Long.MAX_VALUE;
        for (int i=0; i < n; ++i) {
            long candidate = totalSum - (n-i)*1L*beans[i];
            ans= Math.min(ans, candidate);
        }
        return ans;
    }
}