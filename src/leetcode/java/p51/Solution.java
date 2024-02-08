package leetcode.java.p51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<List<String>> answers = new ArrayList<>();
        boolean grid[][] = new boolean[n][n];
        List<String> cur = new ArrayList<>();
        findAnswer(grid, answers, cur, 0);
        return answers;
    }

    private String makeRow(final int c) {
        return ".".repeat(c) + "Q" + ".".repeat(n - 1 - c);
    }

    private void findAnswer(boolean[][] grid, List<List<String>> answers, List<String> cur, int r) {
        if (r == n) {
            List<String> ans = new ArrayList<>();
            ans.addAll(cur);
            answers.add(ans);
            return;
        }
        for (int c = 0; c < n; ++c) {
            if (canPut(grid, r, c)) {
                grid[r][c] = true;
                cur.add(makeRow(c));
                findAnswer(grid, answers, cur, r + 1);
                cur.remove(cur.size() - 1);
                grid[r][c] = false;
            }
        }
    }

    private boolean canPut(final boolean[][] grid, final int r, final int c) {
        int i, j;
        i = r - 1;
        while (i >= 0) {
            if (grid[i][c])
                return false;
            --i;
        }
        i = r - 1;
        j = c - 1;
        while (i >= 0 && j >= 0) {
            if (grid[i][j])
                return false;
            --i;
            --j;
        }
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < n) {
            if (grid[i][j])
                return false;
            --i;
            ++j;
        }
        return true;
    }
}