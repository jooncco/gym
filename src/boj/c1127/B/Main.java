package boj.c1127.B;
// https://codejam.lge.com/contest/problem/1127/2

import java.util.*;
import java.io.*;

/**
 * DP
 * | Time: O(n 2^n)
 * | Space: O(n 2^n)
 */
public class Main {
    private static FastScanner sc = new FastScanner();
    private static double[][] cc;

    private static void solve() {
        int n= sc.nextInt();
        cc= new double[n][1<<n];
        for (int i=0; i < n; ++i) {
            for (int j=0; j < (1<<n); ++j) {
                cc[i][j]= -1;
            }
        }
        int[] x= new int[n], y= new int[n];
        for (int i= 0; i < n; ++i) {
            x[i]= sc.nextInt();
            y[i]= sc.nextInt();
        }
        double[][] dist= new double[n][n];
        for (int i=0; i < n; ++i) {
            for (int j=0; j < n; ++j) {
                dist[i][j]= Math.sqrt((x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]));
            }
        }
        System.out.print(find(n, dist, 0, 0));
    }

    private static double find(int n, double[][] dist, int curIdx, int mask) {
        if (mask == (1<<n)-1) return dist[curIdx][0];
        if (cc[curIdx][mask] > -1) return cc[curIdx][mask];

        cc[curIdx][mask]= 1e30;
        for (int i=0; i < n; ++i) {
            if (i == curIdx) continue;
            if ((mask & (1<<i)) == 0) {
                cc[curIdx][mask]= Math.min(
                    cc[curIdx][mask], 
                    dist[curIdx][i] + find(n, dist, i, mask|(1<<i)));
            }
        }
        return cc[curIdx][mask];
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
