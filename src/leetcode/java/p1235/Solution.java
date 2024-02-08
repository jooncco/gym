package leetcode.java.p1235;
// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import java.util.*;

/**
 * Greedy, DP(Bottom-up)
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; ++i) { // O(n)
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort((a, b) -> a.end - b.end); // O(n log(n))
        int[] cc = new int[n + 1];
        for (int i = 1; i <= n; ++i) { // O(n log(n))
            cc[i] = cc[i - 1];
            int l = binarySearch(jobs, 0, i - 2, jobs.get(i - 1).start); // O(log(n))
            cc[i] = Math.max(cc[i], jobs.get(i - 1).profit + cc[l + 1]);
        }
        return cc[n];
    }

    int binarySearch(List<Job> jobs, int l, int r, int startTime) {
        while (l < r) {
            int m = (l + r) / 2;
            if (jobs.get(m).end <= startTime)
                l = m + 1;
            else
                r = m;
        }
        return jobs.get(l).end > startTime ? l - 1 : l;
    }

    class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}