package leetcode.p1639;
// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

/**
 * Dynamic Programming (Top-down)
 * | Time: O (nk)
 * | Space: O (nk)
 */
public class Solution {
    private int n, k;
    private int[][] cnt;
    private int[][] cache;
    private final int MOD= 1000*1000*1000+7;

    public int numWays(String[] words, String target) {
        n= words[0].length();
        k= target.length();
        cnt= new int[n][26];
        for (int i=0; i < n; ++i) {
            for (String word : words) {
                ++cnt[i][word.charAt(i)-'a'];
            }
        }
        cache= new int[n][k];
        for (int i=0; i < n; ++i) {
            for (int j=0; j < k; ++j) {
                cache[i][j]= -1;
            }
        }
        return findNumOfWays(words, target, 0, 0);
    }

    private int findNumOfWays(String[] words, String target, int l, int r) {
        if (l >= n) return r >= k ? 1 : 0;
        if (r >= k) return 1;
        if (cache[l][r] > -1) return cache[l][r];

        cache[l][r]= 0;
        int cntForIdx= cnt[l][target.charAt(r)-'a'];
        if (cntForIdx > 0) {
            cache[l][r]= (int)(cache[l][r] + (cntForIdx * 1L * findNumOfWays(words, target, l+1, r+1)) % MOD ) % MOD;
        }
        cache[l][r]= (cache[l][r] + findNumOfWays(words, target, l+1, r)) % MOD;
        return cache[l][r];
    }
}