package leetcode.java.lw-380. C;
// https://leetcode.com/contest/weekly-contest-380/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/

/**
 * Binary Search, Math
 * | Time: O(log(1e16))
 * | Space: O(1)
 */
public class Solution {
    public long findMaximumNumber(long k, int x) {
        long l = 1, r = (long) 1e16;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (price(m, x) <= k)
                l = m + 1;
            else
                r = m;
        }
        return price(l, x) <= k ? l : l - 1;
    }

    private long price(long num, int x) {
        ++num;
        long sum = 0;
        for (int i = x; i < 61; i += x) {
            long d = 1L << i;
            sum += num / d * d / 2;
            sum += Math.max(0, num % d - d / 2);
        }
        return sum;
    }
}