package leetcode.p837;
// https://leetcode.com/problems/new-21-game/

/**
 * Dynamic Programming, Sliding Window
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public double new21Game(int n, int k, int maxPoint) {
        if (k == 0 || k + maxPoint - 1 <= n) return 1;
        double[] cache= new double[n+1];
        double sum= 1.0, ans= 0;
        cache[0]= 1.0;
        for (int i=1; i <= n; ++i) {
            cache[i]= sum / maxPoint;
            if (i < k) sum += cache[i];
            else ans += cache[i];

            if (i - maxPoint >= 0) sum -= cache[i-maxPoint];
        }
        return ans;
    }
}