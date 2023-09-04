package codeforces.c1142;
// https://codeforces.com/contest/1142/problem/B

import java.util.*;
import java.io.*;

/**
 * DP (Binary Lifting)
 * | Time: O(m log(n))
 * | Space: O (n+20m)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt(), m= sc.nextInt(), q= sc.nextInt();
        int[] p= new int[n];
        for (int i=0; i < n; ++i) p[i]= sc.nextInt();
        int[] a= new int[m];
        for (int i=0; i < m; ++i) a[i]= sc.nextInt();
        
        int[] prevNum= new int[n+1];
        for (int i=1; i <= n; ++i) prevNum[p[i%n]]= p[i-1];
        int[] lastIdx= new int[n+1];
        for (int i=1; i <= n; ++i) lastIdx[i]= -1;
        int[][] f= new int[20][m];
        for (int i=0; i < m; ++i) {
            f[0][i]= lastIdx[prevNum[a[i]]];
            lastIdx[a[i]]= i;
        }
        for (int i=1; i < 20; ++i) {
            for (int j=0; j < m; ++j) {
                f[i][j]= f[i-1][j] == -1 ? -1 : f[i-1][f[i-1][j]];
            }
        }
        int[] ans= new int[m];
        ans[0]= getBeginingIdx(f, n-1, 0);
        for (int i=1; i < m; ++i) {
            ans[i]= Math.max(ans[i-1], getBeginingIdx(f, n-1, i));
        }

        while (q-- > 0) {
            int l= sc.nextInt()-1, r= sc.nextInt()-1;
            System.out.print(ans[r] >= l ? "1" : "0");
        }
    }

    private static int getBeginingIdx(int[][] f, int cnt, int idx) {
        for (int i=0; i < 20; ++i) {
            if (idx == -1) return -1;
            if ((cnt & (1<<i)) > 0) {
                idx= f[i][idx];
            }
        }
        return idx;
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
        solve();
    }
}
