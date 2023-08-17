package codeforces.c1860;
// https://codeforces.com/contest/1860/problem/B

import java.util.*;
import java.io.*;

/**
 * Math, Greedy
 * | Time: O (1)
 * | Space: O (1)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int m= sc.nextInt(), k= sc.nextInt(), a1= sc.nextInt(), ak= sc.nextInt();
        m -= Math.min(m/k, ak)*k;
        if (m <= a1) {
            System.out.print(0);
            return;
        }
        System.out.print(m%k > a1 ? m/k + m%k - a1 : (m-a1+(k-1))/k);
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
            if (t > 1)
                System.out.println();
            solve();
        }
    }
}
