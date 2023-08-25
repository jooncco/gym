package codeforces.c1862;
// https://codeforces.com/contest/1862/problem/B

import java.util.*;
import java.io.*;

/**
 * Constructive Algorithms, Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt();
        int[] a= new int[n];
        for (int i=0; i < n; ++i) a[i]= sc.nextInt();
        List<Integer> b= new ArrayList<>();
        b.add(a[0]);
        for (int i=1; i < n; ++i) {
            if (a[i-1] > a[i]) b.add(a[i]);
            b.add(a[i]);
        }
        System.out.println(b.size());
        for (int num : b) System.out.print(num + " ");
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
