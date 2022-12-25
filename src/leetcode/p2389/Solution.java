package leetcode.p2389;
// https://leetcode.com/problems/longest-subsequence-with-limited-sum/

import java.util.Arrays;

public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        final int MAX_VAL= 1000000, n= nums.length, m= queries.length;
        Arrays.sort(nums);
        int[] sums= new int[n];
        sums[0]= nums[0];
        int idx= 1;
        while (idx < n && sums[idx-1]+nums[idx] <= MAX_VAL) {
            sums[idx]= sums[idx-1]+nums[idx];
            ++idx;
        }
        int[] ans= new int[m];
        for (int i=0; i < m; ++i) {
            int l= 0, r= idx-1;
            while (l < r) {
                int cur= (l+r)/2;
                if (sums[cur] > 0 && sums[cur] < queries[i]) l= cur+1;
                else r= cur;
            }
            ans[i]= sums[l] > queries[i] ? l : l+1;
        }
        return ans;
    }
}
