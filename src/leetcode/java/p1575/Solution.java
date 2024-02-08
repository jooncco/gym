package leetcode.java.p1575;
// https://leetcode.com/problems/count-all-possible-routes/

/**
 * Dynamic Programming (Bottom-up)
 * | Time: O (n^2 fuel)
 * | Space: O (n fuel)
 */
public class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int countRoutes(int[] locations, int S, int E, int fuel) {
        int n = locations.length;
        int[][] cache = new int[n][fuel + 1];
        for (int f = 0; f <= fuel; ++f)
            cache[E][f] = 1;

        for (int f = 1; f <= fuel; ++f) {
            for (int s = 0; s < n; ++s) {
                for (int i = 0; i < n; ++i) {
                    if (s == i)
                        continue;
                    int fuelToGetToIntermediate = Math.abs(locations[i] - locations[s]);
                    if (fuelToGetToIntermediate <= f) {
                        cache[s][f] = add(cache[s][f], cache[i][f - fuelToGetToIntermediate]);
                    }
                }
            }
        }
        return cache[S][fuel];
    }

    private int add(long a, long b) {
        return (int) ((a + b) % MOD);
    }
}