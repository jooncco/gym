package leetcode.p974;
// https://leetcode.com/problems/subarray-sums-divisible-by-k/

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n= nums.length;
        int[] freq= new int[k];
        int prefixSum= 0;
        for (int num : nums) {
            prefixSum= (prefixSum+num)%k;
            if (prefixSum < 0) prefixSum += k;
            ++freq[prefixSum];
        }
        int ans= 0;
        // intervals
        for (int i=0; i < k; ++i) {
            if (freq[i] > 1) {
                ans += (freq[i])*(freq[i]-1)/2;
            }
        }
        // nums[i] % k == 0
        ans += freq[0];
        return ans;
    }
}