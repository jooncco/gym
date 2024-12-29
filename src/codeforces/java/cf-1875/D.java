package codeforces.c1875;
// https://codeforces.com/contest/1875/problem/D

import java.util.*;
import java.io.*;

/**
 * DP (Top Down)
 * | Time: O(n)
 * | Space: O(n)
 */
public class D {
    private static final FastScanner sc = new FastScanner();
    private static int[] cc, cnt;

    private static void solve() {
        int n= sc.nextInt();
        int[] a= new int[n];
        for (int i=0; i < n; ++i) a[i]= sc.nextInt();
        Arrays.sort(a);
        int mex= 0;
        for (int num : a) {
            if (mex == num) ++mex;
        }
        
        cc= new int[mex+1];
        for (int i=0; i <= mex; ++i) cc[i]= -1;
        cnt= new int[mex];
        for (int i=0; i < n; ++i) {
            if (a[i] >= mex) break;
            ++cnt[a[i]];
        }

        System.out.print(dp(mex));
    }

    private static int dp(int mex) {
        if (mex == 0) return 0;
        if (cc[mex] > -1) return cc[mex];

        cc[mex]= Integer.MAX_VALUE;
        for (int i= 0; i < mex; ++i) {
            cc[mex]= Math.min(cc[mex], (cnt[i]-1)*mex + i + dp(i));
        }
        return cc[mex];
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
