package leetcode.p1512;
// https://leetcode.com/problems/number-of-good-pairs/

/**
 * Math(Combinatorics)
 * | Time: O(n)
 * | Space: O(max(nums[i]))
 */
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt= new int[101];
        for (int num : nums) ++cnt[num];
        int ans= 0;
        for (int i=1; i <= 100; ++i) {
            if (cnt[i] > 1) {
                ans += cnt[i]*(cnt[i]-1)/2;
            }
        }
        return ans;
    }
}