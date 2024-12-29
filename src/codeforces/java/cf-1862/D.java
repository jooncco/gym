package codeforces.c1862;
// https://codeforces.com/contest/1862/problem/D

import java.util.*;
import java.io.*;

/**
 * Binary Search, Math(Number Theory)
 * | Time: O (log n)
 * | Space: O (1)
 */
public class D {
    private static FastScanner sc = new FastScanner();
    
    private static void solve() {
        long n= sc.nextLong();
        long l= 0, r= 3000_000_000l;
        while (l < r) {
            long m= (l+r)/2;
            if ((m+1)*(m+2)/2 <= n) l= m+1;
            else r= m;
        }
        n -= l*(l+1)/2;
        System.out.print(l+1+n);
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