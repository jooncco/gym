package algospot.TSP1;
// https://www.algospot.com/judge/problem/read/TSP1

import java.util.*;
import java.io.*;

public class Main {
    private static final FastScanner sc = new FastScanner();
    private static final int INF= 987654321;

    private static double[][] cc;

    private static void solve() {
        int n= sc.nextInt();
        double[][] dist= new double[n][n];
        for (int i= 0; i < n; ++i) {
            for (int j= 0; j < n; ++j) {
                dist[i][j]= sc.nextDouble();
            }
        }

        cc= new double[n][1<<n];
        for (int j= 0; j < n; ++j) {
            for (int k= 0; k < 1<<n; ++k) {
                cc[j][k]= -1;
            }
        }
        double ans= INF;
        for (int i= 0; i < n; ++i) {
            ans= Math.min(ans, dp(n, dist, i, 1<<i));
        }
        System.out.print(ans);
    }

    private static double dp(int n, double[][] dist, int cur, int mask) {
        if (mask == (1<<n)-1) return 0.0;
        if (cc[cur][mask] > -1) return cc[cur][mask];
        
        cc[cur][mask]= INF;
        for (int i= 0; i < n; ++i) {
            if ((mask & (1<<i)) > 0) continue;
            cc[cur][mask]= Math.min(cc[cur][mask], dist[cur][i] + dp(n, dist, i, mask|(1<<i)));
        }
        return cc[cur][mask];
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