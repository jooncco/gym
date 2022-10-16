package leetcode.p1335;
// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

import java.util.Arrays;

public class Solution {
    int n;
    int[][] cache;
    int[] maxDiff;

    public int minDifficulty(int[] jobDifficulty, int d) {
        n= jobDifficulty.length;
        cache= new int[n][d+1];
        for (int i=0; i < n; ++i) Arrays.fill(cache[i], -1);
        maxDiff= new int[n];
        maxDiff[n-1]= jobDifficulty[n-1];
        for (int i=n-2; i >= 0; --i) maxDiff[i]= Math.max(jobDifficulty[i], maxDiff[i+1]);
        return find(jobDifficulty, 0, d);
    }

    private int find(final int[] jobDifficulty, final int idx, final int d) {
        if (n-idx < d) return -1;
        if (d == 1) return maxDiff[idx];
        if (cache[idx][d] > -1) return cache[idx][d];

        cache[idx][d]= jobDifficulty[idx] + find(jobDifficulty, idx+1, d-1);
        int jobs= 1, todayDiff= jobDifficulty[idx];
        while (find(jobDifficulty, idx+jobs+1, d-1) > -1) {
            ++jobs;
            todayDiff= Math.max(todayDiff, jobDifficulty[idx-1+jobs]);
            cache[idx][d]= Math.min(cache[idx][d], todayDiff + find(jobDifficulty, idx+jobs, d-1));
        }
        return cache[idx][d];
    }
}