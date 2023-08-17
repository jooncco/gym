package codeforces.c1860;
// https://codeforces.com/contest/1860/problem/A

import java.util.*;
import java.io.*;

/**
 * Constructive Algorithms
 * | Time: O (n)
 * | Space: O (n)
 */
public class A {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        String str= sc.next();
        final int n= str.length();
        if ("()".equals(str)) {
            System.out.print("NO");
            return;
        }
        System.out.println("YES");
        boolean alternates= true;
        for (int i= 1; i < n; ++i) {
            if (str.charAt(i) == str.charAt(i-1)) {
                alternates= false;
                break;
            }
        }
        StringBuilder sb= new StringBuilder();
        if (alternates) {
            for (int i= 0; i < n; ++i) sb.append("(");
            for (int i= 0; i < n; ++i) sb.append(")");
        } else {
            for (int i= 0; i < n; ++i) sb.append("()");
        }
        System.out.print(sb);
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
