package leetcode.java.p474;
// https://leetcode.com/problems/ones-and-zeroes/

public class Solution {
    private int N;
    private int ones[], zeros[];
    private Integer cache[][][];

    public int findMaxForm(String[] strs, int m, int n) {
        this.N = strs.length;
        ones = new int[N];
        zeros = new int[N];
        cache = new Integer[N][m + 1][n + 1];

        for (int i = 0; i < N; ++i) {
            for (char c : strs[i].toCharArray()) {
                if (c == '1')
                    ones[i]++;
                if (c == '0')
                    zeros[i]++;
            }
        }
        return maximumSizeOfSubset(0, strs, m, n);
    }

    public int maximumSizeOfSubset(int curIdx, String[] strs, int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MIN_VALUE;
        if (curIdx == N)
            return 0;
        if (cache[curIdx][m][n] != null)
            return cache[curIdx][m][n];

        cache[curIdx][m][n] = Math.max(
                1 + maximumSizeOfSubset(curIdx + 1, strs, m - zeros[curIdx], n - ones[curIdx]),
                maximumSizeOfSubset(curIdx + 1, strs, m, n));
        return cache[curIdx][m][n];
    }
}