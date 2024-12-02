package codeforces.c1862;
// https://codeforces.com/contest/1862/problem/C

import java.util.*;
import java.io.*;

/**
 * Implementation, Math
 * | Time: O (n)
 * | Space: O (n)
 */
public class C {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt();
        int[] a= new int[n];
        for (int i= 0; i < n; ++i) a[i]= sc.nextInt();

        int[] b= new int[n];
        int j= n-1;
        for (int i= 0; i < n; ++i) {
            int h= i+1;
            while (j >= 0 && a[j] < h) --j;
            b[i]= j+1;
        }
        boolean yes= true;
        for (int i=0; i < n; ++i) {
            yes &= a[i] == b[i];
        }
        System.out.print(yes ? "YES":"NO");
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
