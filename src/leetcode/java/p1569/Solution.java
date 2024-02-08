package leetcode.java.p1569;
// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Divide And Conquer, Math (Combinations)
 * | Time: O (N logN)
 * | Space: O (N^2)
 */
public class Solution {
    private static final int MOD = 1000_000_007;
    private static int[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        preCalc(n);
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums)
            numsList.add(num);
        return dfs(numsList) - 1;
    }

    private int dfs(List<Integer> nums) {
        if (nums.isEmpty())
            return 1;
        int root = nums.get(0);
        List<Integer> left = nums
                .stream()
                .filter(num -> num < root)
                .collect(Collectors.toList());
        List<Integer> right = nums
                .stream()
                .filter(num -> num > root)
                .collect(Collectors.toList());
        return mul(comb[nums.size() - 1][left.size()], mul(dfs(left), dfs(right)));
    }

    private int mul(long a, long b) {
        a %= MOD;
        b %= MOD;
        return (int) ((a * b) % MOD);
    }

    private int add(long a, long b) {
        return (int) ((a + b) % MOD);
    }

    private void preCalc(int n) {
        comb = new int[n + 1][n + 1];
        comb[0][0] = comb[1][0] = comb[1][1] = 1;
        for (int i = 2; i <= n; ++i) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                comb[i][j] = add(comb[i - 1][j - 1], comb[i - 1][j]) % MOD;
            }
        }
    }
}