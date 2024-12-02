package codeforces.c1862;
// https://codeforces.com/contest/1862/problem/A

import java.util.*;
import java.io.*;

/**
 * Greedy, DP
 * | Time: O (nm)
 * | Space: O (nm)
 */
public class A {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt(), m= sc.nextInt();
        String[] carpet= new String[n];
        for (int i= 0; i < n; ++i) {
            carpet[i]= sc.next();
        }
        char[] name= new char[]{'v', 'i', 'k', 'a'};
        int idx= 0;
        for (int i=0; i < m; ++i) {
            if (idx == name.length) break;
            for (int j=0; j < n; ++j) {
                if (carpet[j].charAt(i) == name[idx]) {
                    ++idx;
                    break;
                }
            }
        }
        System.out.print(idx == 4 ? "YES":"NO");
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
