package leetcode.java.p36;
// https://leetcode.com/problems/valid-sudoku/

public class Solution {
    private static final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        int rows[] = new int[N];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (board[r][c] == '.')
                    continue;
                int num = board[r][c] - '0';
                if ((rows[r] & (1 << num)) > 0)
                    return false;
                rows[r] |= (1 << num);
            }
        }
        int cols[] = new int[N];
        for (int c = 0; c < N; ++c) {
            for (int r = 0; r < N; ++r) {
                if (board[r][c] == '.')
                    continue;
                int num = board[r][c] - '0';
                if ((cols[c] & (1 << num)) > 0)
                    return false;
                cols[c] |= (1 << num);
            }
        }
        int groups[] = new int[N];
        for (int g = 0; g < N; ++g) {
            int R = g / 3 * 3, C = g % 3 * 3;
            for (int r = 0; r < 3; ++r) {
                for (int c = 0; c < 3; ++c) {
                    if (board[R + r][C + c] == '.')
                        continue;
                    int num = board[R + r][C + c];
                    if ((groups[g] & (1 << num)) > 0)
                        return false;
                    groups[g] |= (1 << num);
                }
            }
        }
        return true;
    }
}