package leetcode.java.p983;
// https://leetcode.com/problems/minimum-cost-for-tickets/

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        final int N = days.length;
        final int INF = 365 * 1000 + 1;
        final int[] PASS_LEN = { 1, 7, 30 };

        int[] cache = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            cache[i] = INF;
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < 3; ++j) {
                int cost = costs[j];
                int passExpirationDate = days[i - 1] + PASS_LEN[j];
                int idx = i;
                while (idx <= N && days[idx - 1] < passExpirationDate) {
                    cache[idx] = Math.min(cache[idx], cache[i - 1] + cost);
                    ++idx;
                }
            }
        }
        return cache[N];
    }
}