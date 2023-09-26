package algospot.BOARDCOVER;
// https://www.algospot.com/judge/problem/read/BOARDCOVER

import java.util.*;
import java.io.*;

/**
 * DFS (Brute Force)
 * | Time: O(4^(n/3)) / n: # of '.'
 * | Space: O(n/3) / n: # of '.'
 */
public class Main {
    private static final FastScanner sc = new FastScanner();
    private static final int[][][] L= {
        {{0, 0}, {0, 1}, {1, 0}},
        {{0, 0}, {0, 1}, {1, 1}},
        {{0, 0}, {1, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {1, -1}}
    };

    private static int H, W, ans;

    private static void solve() {
        H= sc.nextInt(); W= sc.nextInt();
        char[][] grid= new char[H][W];
        for (int i= 0; i < H; ++i) grid[i]= sc.next().toCharArray();

        int cnt= 0;
        for (int i= 0; i < H; ++i) {
            for (int j= 0; j < W; ++j) {
                if (grid[i][j] == '.') ++cnt;
            }
        }
        if (cnt%3 > 0) {
            System.out.print(0);
            return;
        }
        
        ans= 0;
        dfs(grid, 0, 0, cnt);
        System.out.print(ans);
    }

    private static void dfs(char[][] grid, int r, int c, int cnt) {
        if (cnt == 0) {
            ++ans;
            return;
        }
        if (c == W) {
            dfs(grid, r+1, 0, cnt);
            return;
        }
        if (r >= H) return;

        if (grid[r][c] == '.') {
            for (int[][] l : L) {
                if (canPut(grid, r, c, l)) {
                    for (int[] block : l) grid[r+block[0]][c+block[1]]= '-';
                    dfs(grid, r, c+1, cnt-3);
                    for (int[] block : l) grid[r+block[0]][c+block[1]]= '.';
                }
            }
        }
        else dfs(grid, r, c+1, cnt);
    }

    private static boolean canPut(char[][] grid, int r, int c, int[][] l) {
        for (int[] block : l) {
            int curR= r+block[0], curC= c+block[1];
            if (curR < 0 || curC < 0 || curR >= H || curC >= W) return false;
            if (grid[curR][curC] != '.') return false;
        }
        return true;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            if (t > 1) System.out.println();
            solve();
        }
    }
}
