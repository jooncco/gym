package codeforces.c1855;
// https://codeforces.com/contest/1855/problem/A

import java.io.*;
import java.util.*;

/**
 * Greedy, Math
 * | Time: O (n)
 * | Space: O (n)
 */
public class A {
    private static FastScanner sc = new FastScanner();

    private static int solve() throws IOException {
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            int p = sc.nextInt();
            if (i == p)
                ++cnt;
        }
        return (cnt + 1) / 2;
    }

    private static class FastScanner {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");

        static String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
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
