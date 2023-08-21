package codeforces.c1857;
// https://codeforces.com/contest/1857/problem/A

import java.util.*;
import java.io.*;

/**
 * Math, Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class A {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        int n = sc.nextInt();
        int num, oddCnt = 0;
        for (int i = 0; i < n; ++i) {
            num = sc.nextInt();
            if (num % 2 == 1)
                ++oddCnt;
        }
        return oddCnt % 2 == 0 ? "YES" : "NO";
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