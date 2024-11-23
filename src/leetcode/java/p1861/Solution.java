package leetcode.java.p1861;
// https://leetcode.com/problems/rotating-the-box/

/**
 * Brute Force
 * Time: O (mn)
 * Space: O (mn)
 */
public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];
        // rotate
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[j][m - 1 - i] = box[i][j];
            }
        }
        // gravity
        for (int c = 0; c < m; ++c) {
            for (int r = n - 1; r > 0; --r) {
                int cnt = 0;
                int tmpR = r;
                while (tmpR >= 0 && ans[tmpR][c] != '*') {
                    if (ans[tmpR][c] == '#')
                        ++cnt;
                    --tmpR;
                }
                for (int h = r; h > tmpR; --h) {
                    ans[h][c] = cnt > 0 ? '#' : '.';
                    --cnt;
                }
                r = tmpR;
            }
        }
        return ans;
    }
}