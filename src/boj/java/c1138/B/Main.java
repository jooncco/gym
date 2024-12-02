package boj.c1138.B;

import java.util.*;
import java.io.*;

public class Main {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt(), m= sc.nextInt(), k= sc.nextInt();
        char[][] grid= new char[n][m];
        for (int i= 0; i < n; ++i) {
            grid[i]= sc.next().toCharArray();
        }

        int half= k/2;
        int ans= Integer.MAX_VALUE;
        for (int i=half; i < n-half; ++i) {
            for (int j=half; j < m-half; ++j) {
                ans= Math.min(ans, compute(grid, i, j, half));
            }
        }
        System.out.print(ans);
    }

    private static int compute(char[][] grid, int r, int c, int half) {
        int a= 0, b= 0;
        for (int i=r-half; i <= r+half; ++i) {
            for (int j=c-half; j <= c+half; ++j) {
                if (grid[i][j] == '1') {
                    a += Math.abs(r-i) + Math.abs(c-j);
                }
                if (grid[i][j] == '2') {
                    b += Math.abs(r-i) + Math.abs(c-j);
                }
            }
        }
        return Math.abs(a-b);
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
        solve();
    }
}
