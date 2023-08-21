package codeforces.c1859;
// https://codeforces.com/contest/1859/problem/A

import java.util.*;
import java.io.*;

/**
 * Constructive Algorithms, Math, Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class A {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        int maxVal = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
            maxVal = Math.max(maxVal, a[i]);
        }
        List<Integer> b = new ArrayList<>(), c = new ArrayList<>();
        for (int num : a) {
            if (num == maxVal) c.add(num);
            else b.add(num);
        }
        if (c.size() == n) {
            System.out.print("-1");
            return;
        }

        System.out.println(b.size()+" "+c.size());
        for (int i = 0; i < b.size(); ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(b.get(i));
        }
        System.out.println();
        for (int i = 0; i < c.size(); ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(c.get(i));
        }
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
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            if (t > 1) System.out.println();
            solve();
        }
    }
}
