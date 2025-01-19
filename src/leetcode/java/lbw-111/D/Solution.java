package leetcode.java.lbw-111.D;
// https://leetcode.com/contest/biweekly-contest-111/problems/number-of-beautiful-integers-in-the-range/

import java.util.*;

/**
 * DP
 * Time: O (log(high)^3*k)
 * Space: O (log(high)^3*k)
 */
public class Solution {
    private int n, k;
    private List<Integer> upperBound;
    private int[][][][][][] cc;

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        init(low - 1);
        int L = howMany(0, 0, 1, 0, 0, 1);
        init(high);
        int R = howMany(0, 0, 1, 0, 0, 1);
        return R - L;
    }

    private int howMany(int idx, int m, int tight, int odd, int even, int zero) {
        if (idx == n)
            return odd + even > 0 && odd == even && m == 0 ? 1 : 0;
        if (cc[idx][m][tight][odd][even][zero] > -1)
            return cc[idx][m][tight][odd][even][zero];

        cc[idx][m][tight][odd][even][zero] = 0;
        int nextM, nextOdd, nextEven, nextZero;
        if (tight == 1) {
            for (int i = 0; i <= upperBound.get(idx); ++i) {
                nextM = (10 * m + i) % k;
                nextOdd = odd + i % 2;
                nextEven = zero == 1 && i == 0 ? 0 : even + (i % 2 ^ 1);
                nextZero = zero == 1 && i == 0 ? 1 : 0;
                cc[idx][m][tight][odd][even][zero] += howMany(idx + 1, nextM, i == upperBound.get(idx) ? 1 : 0, nextOdd,
                        nextEven, nextZero);
            }
        } else {
            for (int i = 0; i < 10; ++i) {
                nextM = (10 * m + i) % k;
                nextOdd = odd + i % 2;
                nextEven = zero == 1 && i == 0 ? 0 : even + (i % 2 ^ 1);
                nextZero = zero == 1 && i == 0 ? 1 : 0;
                cc[idx][m][tight][odd][even][zero] += howMany(idx + 1, nextM, 0, nextOdd, nextEven, nextZero);
            }
        }
        return cc[idx][m][tight][odd][even][zero];
    }

    private void init(int num) {
        upperBound = new ArrayList<>();
        while (num > 0) {
            upperBound.add(0, num % 10);
            num /= 10;
        }
        n = upperBound.size();
        cc = new int[upperBound.size()][20][2][10][10][2];
        for (int i = 0; i < upperBound.size(); ++i) {
            for (int j = 0; j < 20; ++j) {
                for (int q = 0; q < 2; ++q) {
                    for (int l = 0; l < 10; ++l) {
                        for (int e = 0; e < 10; ++e) {
                            for (int z = 0; z < 2; ++z) {
                                cc[i][j][q][l][e][z] = -1;
                            }
                        }
                    }
                }
            }
        }
    }
}