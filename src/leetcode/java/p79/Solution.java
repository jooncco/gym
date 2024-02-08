package leetcode.java.p79;
// https://leetcode.com/problems/word-search/

public class Solution {
    private int m, n;
    private char[][] board;
    private String word;
    private int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.word = word;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (board[r][c] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[r][c] = true;
                    if (dfs(visited, r, c, 0))
                        return true;
                    visited[r][c] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited, int r, int c, int idx) {
        if (idx == word.length() - 1)
            return true;

        boolean exist = false;
        int nr, nc;
        for (int i = 0; i < 4; ++i) {
            nr = r + dr[i];
            nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;
            if (visited[nr][nc])
                continue;
            if (board[nr][nc] != word.charAt(idx + 1))
                continue;
            visited[nr][nc] = true;
            if (dfs(visited, nr, nc, idx + 1))
                exist = true;
            visited[nr][nc] = false;
        }
        return exist;
    }
}