package codeforces.c1857;
// https://codeforces.com/contest/1857/problem/D

import java.util.*;
import java.io.*;

/**
 * Math, Sortings
 * | Time: O (n + nlog(n))
 * | Space: O (n)
 */
public class D {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; ++i)
            b[i] = sc.nextInt();

        int maxVal = -2 * (int) (1e9) - 10;
        int[] diff = new int[n];
        for (int i = 0; i < n; ++i) {
            diff[i] = a[i] - b[i];
            maxVal = Math.max(maxVal, diff[i]);
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (diff[i] == maxVal) {
                if (cnt > 0)
                    sb.append(" ");
                sb.append(i + 1);
                ++cnt;
            }
        }
        return cnt + "\n" + sb.toString();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            if (t > 1)
                sb.append("\n");
            sb.append(solve());
        }
        System.out.print(sb);
    }
}