package codeforces.c1875;
// https://codeforces.com/contest/1875/problem/B

import java.util.*;
import java.io.*;

/**
 * Greedy
 * | Time: O(n+m)
 * | Space: O(n+m)
 */
public class B {
    private static final FastScanner sc = new FastScanner();
    
    private static void solve() {
        int n= sc.nextInt(), m= sc.nextInt(), k= sc.nextInt();
        int[] a= new int[n];
        int aMax= Integer.MIN_VALUE, aMin= Integer.MAX_VALUE;
        for (int i= 0; i < n; ++i) {
            a[i]= sc.nextInt();
            aMax= Math.max(aMax, a[i]);
            aMin= Math.min(aMin, a[i]);
        }
        int[] b= new int[m];
        int bMax= Integer.MIN_VALUE, bMin= Integer.MAX_VALUE;
        for (int i= 0; i < m; ++i) {
            b[i]= sc.nextInt();
            bMax= Math.max(bMax, b[i]);
            bMin= Math.min(bMin, b[i]);
        }
        int mx= Math.max(aMax, bMax);
        int mn= Math.min(aMin, bMin);
        long ans= sum(a);
        if (aMin < bMax) {
            ans += (- aMin + bMax);
        }
        if (k%2 == 1) {
            System.out.print(ans);
            return;
        }
        ans += (- mx + mn);
        System.out.print(ans);
    }

    private static long sum(int[] arr) {
        long ret= 0;
        for (int num : arr) {
            ret += num;
        }
        return ret;
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