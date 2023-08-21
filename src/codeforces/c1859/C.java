package codeforces.c1859;
// https://codeforces.com/contest/1859/problem/C

import java.util.*;
import java.io.*;

/**
 * Greedy, Brute Force, Number Theory
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class C {
    private static FastScanner sc = new FastScanner();

    private static long solve() {
        int n = sc.nextInt();
        long ans = 0;
        for (int cnt = 0; cnt <= n; ++cnt) {
            long sum = 0, mx = 0;
            int p = n;
            for (int i = 1; i <= n; ++i) {
                int num = i <= n - cnt ? i * i : i * p;
                sum += num;
                mx = Math.max(mx, num);
                if (i > n - cnt)
                    --p;
            }
            sum -= mx;
            ans = Math.max(ans, sum);
        }
        return ans;
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