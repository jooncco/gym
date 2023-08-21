package codeforces.c1857;
// https://codeforces.com/contest/1857/problem/C

import java.util.*;
import java.io.*;

/**
 * Greedy, Sortings
 * | Time: O (n^2 log(n^2))
 * | Space: O (n^2)
 */
public class C {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        int n = sc.nextInt();
        int[] b = new int[n * (n - 1) / 2];
        for (int i = 0; i < b.length; ++i)
            b[i] = sc.nextInt();
        Arrays.sort(b);
        int[] a = new int[n];
        int idx = 0;
        for (int i = 0; i < n - 1; ++i) {
            a[i] = b[idx];
            idx += (n - 1 - i);
        }
        a[n - 1] = (int) 1e9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (i > 0)
                sb.append(" ");
            sb.append(a[i]);
        }
        return sb.toString();
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