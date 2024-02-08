package leetcode.java.p1695;
// https://leetcode.com/problems/maximum-erasure-value/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Integer> S;

    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        S = new HashSet<>();
        S.add(nums[0]);
        int l = 0, maxScore = nums[0], curScore = nums[0];
        for (int i = 1; i < n; ++i) {
            if (S.contains(nums[i])) {
                while (nums[l] != nums[i]) {
                    S.remove(nums[l]);
                    curScore -= nums[l];
                    ++l;
                }
                ++l;
            } else {
                S.add(nums[i]);
                curScore += nums[i];
            }
            maxScore = Math.max(maxScore, curScore);
        }
        return maxScore;
    }
}
