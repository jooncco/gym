package leetcode.java.p149;
// https://leetcode.com/problems/max-points-on-a-line/

public class Solution {
    public int maxPoints(int[][] points) {
        int ans = 2;
        for (int i = 0; i < points.length; ++i) {
            int cur = 2;
            for (int j = i + 1; j < points.length; ++j) {
                int[] a = points[i], b = points[j];
                for (int k = 0; k < points.length; ++k) {
                    if (k == i || k == j)
                        continue;
                    int[] c = points[k];
                    if (c[1] - a[1] == (b[1] - a[1]) / (b[0] - a[0]) * (c[0] - a[0]))
                        ++cur;
                }
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}