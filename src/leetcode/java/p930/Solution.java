package leetcode.java.p930;
// https://leetcode.com/problems/binary-subarrays-with-sum/

/**
 * Prefix sum
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int prefixSumCnt[] = new int[n + 1];
        prefixSumCnt[0] = 1;

        int countOfSubarray = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                countOfSubarray += prefixSumCnt[sum - goal];
            }
            prefixSumCnt[sum]++;
        }
        return countOfSubarray;
    }
}