package leetcode.p1444;
// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

public class Solution {
    private final int MOD= 1000000007;

    private int m, n;
    private int[][][] numOfApples;
    private int[][] applesInRemainingPiece;
    private int[][][] cache;

    public int ways(String[] pizza, int k) {
        init(pizza, k);
        return ways(k-1, 0, 0);
    }

    private int ways(int cuts, int r, int c) {
        if (r >= m || c >= n) return 0;
        if (cuts == 0) return applesInRemainingPiece[r][c] > 0 ? 1 : 0;
        if (cache[r][c][cuts] > -1) return cache[r][c][cuts];

        cache[r][c][cuts]= 0;
        int applesInThisPiece= 0;
        for (int i=r; i < m; ++i) {
            applesInThisPiece += numOfApples[i][c][0];
            if (applesInThisPiece == 0) continue;
            cache[r][c][cuts]= (cache[r][c][cuts] + ways(cuts-1, i+1, c)) % MOD;
        }
        applesInThisPiece= 0;
        for (int i=c; i < n; ++i) {
            applesInThisPiece += numOfApples[r][i][1];
            if (applesInThisPiece == 0) continue;
            cache[r][c][cuts]= (cache[r][c][cuts] + ways(cuts-1, r, i+1)) % MOD;
        }
        return cache[r][c][cuts];
    }

    private void init(String[] pizza, int k) {
        m= pizza.length;
        n= pizza[0].length();
        numOfApples= new int[m][n][2];
        // rows
        for (int r= m-1; r >= 0; --r) {
            for (int c= n-1; c >= 0; --c) {
                numOfApples[r][c][0]= 'A' == pizza[r].charAt(c) ? 1 : 0;
                if (c < n-1) numOfApples[r][c][0] += numOfApples[r][c+1][0];
            }
        }
        // columns
        for (int c= n-1; c >= 0; --c) {
            for (int r= m-1; r >= 0; --r) {
                numOfApples[r][c][1]= 'A' == pizza[r].charAt(c) ? 1 : 0;
                if (r < m-1) numOfApples[r][c][1] += numOfApples[r+1][c][1];
            }
        }
        // remaining piece
        applesInRemainingPiece= new int[m][n];
        for (int r=m-1; r >= 0; --r) {
            for (int c=n-1; c >= 0; --c) {
                applesInRemainingPiece[r][c]= 'A' == pizza[r].charAt(c) ? 1 : 0;
                if (c < n-1) applesInRemainingPiece[r][c] += applesInRemainingPiece[r][c+1];
            }
        }
        for (int c=n-1; c >= 0; --c) {
            for (int r=m-2; r >= 0; --r) {
                applesInRemainingPiece[r][c] += applesInRemainingPiece[r+1][c];
            }
        }
        cache= new int[m][n][k];
        for (int r=0; r < m; ++r) {
            for (int c=0; c < n; ++c) {
                for (int l= 0; l < k; ++l) {
                    cache[r][c][l]= -1;
                }
            }
        }
    }
}