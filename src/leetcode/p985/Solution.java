package leetcode.p985;
// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

import java.util.Arrays;

public class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum= Arrays.stream(nums).filter(a -> a%2 == 0).sum();
        int[] ans= new int[queries.length];
        for (int i=0; i < queries.length; ++i) {
            int idx= queries[i][1], val= queries[i][0];
            if (nums[idx]%2 == 0) sum -= nums[idx];
            nums[idx] += val;
            if (nums[idx]%2 == 0) sum += nums[idx];
            ans[i]= sum;
        }
        return ans;
    }
}