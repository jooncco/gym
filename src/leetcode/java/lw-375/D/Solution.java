package leetcode.java.lw-375.D;
// https://leetcode.com/contest/weekly-contest-375/problems/count-the-number-of-good-partitions/

import java.util.*;

/**
 * Stack
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> seenAt = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (seenAt.containsKey(nums[i])) {
                int idx = seenAt.get(nums[i]);
                while (!stack.empty() && stack.peek()[1] >= idx)
                    stack.pop();
                stack.push(new int[] { idx, i });
            } else {
                seenAt.put(nums[i], i);
                stack.push(new int[] { i, i });
            }
        }
        return binEx(2, stack.size() - 1);
    }

    private static final int MOD = (int) 1e9 + 7;

    private static int mul(int a, int b) {
        return (int) (a * 1L * b % MOD);
    }

    private static int binEx(int a, int x) {
        if (x == 0)
            return 1;
        int p = binEx(a, x >> 1);
        p = mul(p, p);
        return (x & 1) == 1 ? mul(p, a) : p;
    }
}