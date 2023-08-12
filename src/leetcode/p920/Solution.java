package leetcode.p920;
// https://leetcode.com/problems/number-of-music-playlists/

/**
 * Combinatorics, DP
 * | Time: O (goal*n)
 * | Space: O (goal*n)
 */
public class Solution {
    private final int MOD = (int) 1e9 + 7;
    private int[][] comb = new int[101][101];

    public int numMusicPlaylists(int n, int goal, int k) {
        preCalculate();
        int[][] cc = new int[goal + 1][n + 1];
        cc[0][0] = 1;
        for (int len = 1; len <= goal; ++len) {
            for (int num = 1; num <= Math.min(len, n); ++num) {
                cc[len][num] = mul(cc[len - 1][num - 1], n - num + 1);
                if (num - k > 0)
                    cc[len][num] = add(cc[len][num], mul(cc[len - 1][num], num - k));
            }

        }
        return cc[goal][n];
    }

    private void preCalculate() {
        comb[0][0] = comb[1][0] = comb[1][1] = 1;
        for (int i = 2; i <= 100; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    comb[i][j] = 1;
                else
                    comb[i][j] = add(comb[i - 1][j - 1], comb[i - 1][j]);
            }
        }
    }

    private int mul(long a, long b) {
        return (int) ((a * b) % MOD);
    }

    private int add(long a, long b) {
        return (int) ((a + b) % MOD);
    }
}