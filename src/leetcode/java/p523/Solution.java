package leetcode.java.p523;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int cumulativeSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            cumulativeSum = (cumulativeSum + nums[i]) % k;
            Integer prev = map.get(cumulativeSum);
            if (prev != null && i - prev > 1)
                return true;
            map.putIfAbsent(cumulativeSum, i);
        }
        return false;
    }
}