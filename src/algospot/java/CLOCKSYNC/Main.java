package algospot.CLOCKSYNC;
// https://www.algospot.com/judge/problem/read/CLOCKSYNC

import java.util.*;
import java.io.*;

/**
 * Brute Force
 * | Time: O(4^n) where n := # of buttons
 * | Space: O(n)
 */
public class Main {
    private static final FastScanner sc = new FastScanner();
    private static final int INF= 987654321;
    private static final int[][] buttons= {{0, 1, 2}, {3, 7, 9, 11}, {4, 10, 14, 15}, {0, 4, 5, 6, 7},
                                           {6, 7, 8, 10, 12}, {0, 2, 14, 15}, {3, 14, 15}, {4, 5, 7, 14, 15},
                                           {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}};
    private static int ans;

    private static void solve() {
        ans= INF;
        long mask= 0;
        for (int i= 0; i < 16; ++i) {
            int clock= sc.nextInt();
            if (clock == 3) mask |= (1L << (i<<1));
            if (clock == 6) mask |= (2L << (i<<1));
            if (clock == 9) mask |= (3L << (i<<1));
        }
        dfs(mask, 0, 0);
        System.out.print(ans == INF ? -1 : ans);
    }

    private static void dfs(long mask, int idx, int curCnt) {
        if (idx == buttons.length) {
            if (mask == 0) {
                ans= Math.min(ans, curCnt);
            }
            return;
        }

        dfs(mask, idx+1, curCnt);
        for (int i= 1; i <= 3; ++i) {
            for (int j : buttons[idx]) {
                mask= clockTick(mask, j);
            }
            dfs(mask, idx+1, curCnt+i);
        }
    }

    private static long clockTick(long mask, int idx) {
        idx <<= 1;
        long nextState= ((((mask & (3L<<idx))>>idx)+1)&3)<<idx;
        mask &= ~(3L<<idx);
        mask |= nextState;
        return mask;
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