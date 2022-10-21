package leetcode.p219;
// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final int n= nums.length;
        Map<Integer, Integer> frequency= new HashMap<>();
        for (int i=0; i < n; ++i) {
            if (i-k-1 >= 0) {
                frequency.put(nums[i-k-1], frequency.get(nums[i-k-1]) - 1);
                if (frequency.get(nums[i-k-1]) == 0) frequency.remove(nums[i-k-1]);
            }
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            if (frequency.get(nums[i]) > 1) return true;
        }
        return false;
    }
}