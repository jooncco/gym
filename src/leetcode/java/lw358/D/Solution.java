package leetcode.java.lw358.D;
// https://leetcode.com/contest/weekly-contest-358/problems/apply-operations-to-maximize-score/

import java.util.*;

/**
 * Greedy, Math
 * | Time: O (n log(n) + kn)
 * | Space: O (n)
 */
public class Solution {
    private final int MOD = (int) (1e9) + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(new int[] { nums.get(i), i });
        }
        int[] primeScore = new int[n];
        for (int i = 0; i < n; ++i) {
            primeScore[i] = countPrimes(nums.get(i));
        }
        arr.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int score = 1;
        int idx = 0;
        while (k > 0) {
            int[] cur = arr.get(idx++);
            int num = cur[0], numsIdx = cur[1];
            int left = 0;
            while (numsIdx - left - 1 >= 0 &&
                    primeScore[numsIdx - left - 1] < primeScore[numsIdx]) {
                ++left;
            }
            int right = 0;
            while (numsIdx + right + 1 < n &&
                    primeScore[numsIdx + right + 1] <= primeScore[numsIdx]) {
                ++right;
            }
            int ops = Math.min(k, mul(left + 1, right + 1));
            score = mul(score, binEx(num, ops));
            k -= ops;
        }
        return score;
    }

    private int countPrimes(int num) {
        if (num == 1)
            return 0;
        int score = 0;
        if (num % 2 == 0) {
            ++score;
            while (num % 2 == 0)
                num /= 2;
        }
        for (int i = 3; i * i <= num; ++i) {
            if (num % i == 0) {
                ++score;
                while (num % i == 0)
                    num /= i;
            }
        }
        return num > 2 ? score + 1 : score;
    }

    private int mul(long a, long b) {
        return (int) (a * b % MOD);
    }

    private int binEx(int a, int x) {
        if (x == 0)
            return 1;
        int p = binEx(a, x / 2);
        p = mul(p, p);
        return x % 2 == 1 ? mul(p, a) : p;
    }
}
