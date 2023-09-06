package codeforces.c1516;
// https://codeforces.com/contest/1516/problem/D

import java.util.*;
import java.io.*;

/**
 * Greedy, DP(Binary Lifting), Number Theory
 * | Time: O(n + q log(n))
 * | Space: O(20n)
 */
public class D {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt(), q= sc.nextInt();
        int mx= 0;
        int[] a= new int[n+1];
        for (int i= 1; i <= n; ++i) {
            a[i]= sc.nextInt();
            mx= Math.max(mx, a[i]);
        }
        
        Map<Integer, List<Integer>> p= new HashMap<>();
        int[] next= new int[mx+1];
        p.put(1, new ArrayList<>());
        // compute primes
        for (int i=2; i <= mx; ++i) {
            if (!p.containsKey(i)) {
                for (int j=i; j <= mx; j += i) {
                    p.computeIfAbsent(j, primes -> new ArrayList<>()).add(i);
                }
                next[i]= n+1;
            }
        }
        
        int[][] cc= new int[20][n+2];
        cc[0][n+1]= n+1;
        for (int i=n; i > 0; --i) {
            cc[0][i]= cc[0][i+1];
            for (int prime : p.get(a[i])) {
                cc[0][i]= Math.min(cc[0][i], next[prime]);
                next[prime]= i;
            }
        }
        for (int i=1; i <= 18; ++i) {
            cc[i][n+1]= n+1;
            for (int j=1; j <= n; ++j) {
                cc[i][j]= cc[i-1][cc[i-1][j]];
            }
        }

        StringBuilder sb= new StringBuilder();
        while (q-- > 0) {
            int l= sc.nextInt(), r= sc.nextInt();
            int ans= 1;
            for (int i=18; i >= 0; --i) {
                if (cc[i][l] <= r) {
                    ans += (1<<i);
                    l= cc[i][l];
                }
            }
            sb.append(ans + "\n");
        }
        System.out.print(sb.toString());
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
