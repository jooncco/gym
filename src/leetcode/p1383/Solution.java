package leetcode.p1383;
// https://leetcode.com/problems/maximum-performance-of-a-team/

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private final int MOD= (int)1e9+7;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> engineers= new LinkedList<>();
        for (int i=0; i < n; ++i) {
            engineers.add(new int[]{ efficiency[i], speed[i] });
        }
        engineers.sort((a,b) -> b[0]-a[0]);

        PriorityQueue<Integer> teamSpeed= new PriorityQueue<>();
        long sumOfSpeed= 0, ans= 0;
        for (final int[] engineer : engineers) {
            sumOfSpeed += engineer[1];
            teamSpeed.add(engineer[1]);
            if (teamSpeed.size() > k) sumOfSpeed -= teamSpeed.poll();
            ans= Math.max(ans, sumOfSpeed*engineer[0]);
        }
        return (int)(ans%MOD);
    }
}