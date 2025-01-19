package leetcode.java.lw-358. A;
// https://leetcode.com/contest/weekly-contest-358/problems/max-pair-sum-in-an-array/

import java.util.*;

/**
 * Implementation
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 10; ++i)
            map.put(i, new ArrayList<>());
        for (int num : nums) {
            int maxDigit = 0;
            int d = num;
            while (d > 0) {
                maxDigit = Math.max(maxDigit, d % 10);
                d /= 10;
            }
            map.get(maxDigit).add(num);
        }
        int ans = -1;
        for (int i = 0; i < 10; ++i) {
            List<Integer> numbers = map.get(i);
            int n = numbers.size();
            if (n > 1) {
                numbers.sort((a, b) -> Integer.compare(a, b));
                ans = Math.max(ans, numbers.get(n - 1) + numbers.get(n - 2));
            }
        }
        return ans;
    }
}
