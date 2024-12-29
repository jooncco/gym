package codeforces.c1875;
// https://codeforces.com/contest/1875/problem/A

import java.util.*;
import java.io.*;

/**
 * Greedy
 * | Time: O(n)
 * | Space: O(n)
 */
public class A {
    private static final FastScanner sc = new FastScanner();

    private static void solve() {
        int a= sc.nextInt(), b= sc.nextInt(), n= sc.nextInt();
        int[] x= new int[n];
        for (int i= 0; i < n; ++i) {
            x[i]= sc.nextInt();
        }
        Arrays.sort(x);
        long ans= 0;
        for (int i=0; i < n; ++i) {
            ans += b-1;
            b= Math.min(1+x[i], a);
        }
        ans += b;
        System.out.print(ans);
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
