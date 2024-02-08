package leetcode.java.p661;
// https://leetcode.com/problems/image-smoother/

/**
 * Sliding Window
 * | Time: O(mn)
 * | Space: O(mn)
 */
public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; ++i) {
            int[] arr0 = calculateDiff(img, i, 0);
            int cnt = arr0[0], sum = arr0[1];
            for (int j = 0; j < n; ++j) {
                int[] arr = calculateDiff(img, i, j + 1);
                cnt += arr[0];
                sum += arr[1];
                ret[i][j] = sum / cnt;
            }
        }
        return ret;
    }

    private int[] calculateDiff(int[][] img, int r, int c) {
        int m = img.length, n = img[0].length;
        int cnt = 0, sum = 0;
        if (c < n) {
            ++cnt;
            sum += img[r][c];
            if (r > 0) {
                ++cnt;
                sum += img[r - 1][c];
            }
            if (r < m - 1) {
                ++cnt;
                sum += img[r + 1][c];
            }
        }
        if (c - 3 >= 0) {
            --cnt;
            sum -= img[r][c - 3];
            if (r > 0) {
                --cnt;
                sum -= img[r - 1][c - 3];
            }
            if (r < m - 1) {
                --cnt;
                sum -= img[r + 1][c - 3];
            }
        }
        return new int[] { cnt, sum };
    }
}
