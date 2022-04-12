package leetcode.p289;
// https://leetcode.com/problems/game-of-life/

class Solution {
    private int dy[]= {-1, -1, -1, 0, 0, 1, 1, 1};
    private int dx[]= {-1, 0, 1, -1, 1, -1, 0, 1};
    private int neighbors = 8;

    private int nextState(final int board[][], int r, int c) {
        int liveCells= 0, ny, nx, m= board.length, n= board[0].length;
        for (int i=0; i < neighbors; ++i) {
            ny= r + dy[i];
            nx= c + dx[i];
            if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
            if (board[ny][nx] == 1) ++liveCells;
        }
        if (board[r][c] == 1 && liveCells >= 2 && liveCells <= 3) return 1;
        if (board[r][c] == 0 && liveCells == 3) return 1;
        return 0;
    }

    public void gameOfLife(int[][] board) {
        int m= board.length, n= board[0].length;
        int nextGenerationBoard[][]= new int[m][n];
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                nextGenerationBoard[i][j]= nextState(board, i, j);
            }
        }
        for (int i=0; i < m; ++i) {
            board[i]= nextGenerationBoard[i].clone();
        }
    }
}
