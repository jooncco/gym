package codeforces.c1875;
// https://codeforces.com/contest/1875/problem/C

import java.util.*;
import java.io.*;

/**
 * Math
 * | Time: O(1)
 * | Space: O(1)
 */
public class C {
    private static final FastScanner sc = new FastScanner();

    private static void solve() {
        long n= sc.nextInt(), m= sc.nextInt();
        n %= m;
        long a= n/gcd(n,m), b= m/gcd(n,m);
        if (popcount(b) > 1) {
            System.out.print(-1);
            return;
        }
        System.out.print(m*popcount(a)-n);
    }

    private static int popcount(long a) {
        int cnt= 0;
        for (int i=0; i < 64; ++i) {
            if ((a & (1L<<i)) > 0) ++cnt;
        }
        return cnt;
    }

    private static long gcd(long a, long b) {
        if (a < b) return gcd(b,a);
        while (b > 0) {
            long tmp= a%b;
            a= b;
            b= tmp;
        }
        return a;
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
