package codeforces.c1857;
// https://codeforces.com/contest/1857/problem/F

import java.util.*;
import java.io.*;

/**
 * Math
 * | Time: O (n+q)
 * | Space: O (n)
 */
public class F {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt();
        Map<Long, Long> cnt= new HashMap<>();
        for (int i= 0; i < n; ++i) {
            long num= sc.nextLong();
            cnt.put(num, cnt.getOrDefault(num, 0L)+1);
        }
        int Q= sc.nextInt();
        for (int q=1; q <= Q; ++q) {
            long a= sc.nextLong(), b= sc.nextLong();
            long ans= 0, x= (a+(long)Math.sqrt(a*a-4*b))/2;
            if ((a-x)*x == b && cnt.containsKey(x) && cnt.containsKey(a-x)) {
                if (x == a-x) ans= cnt.get(x)*(cnt.get(x)-1)/2;
                else ans= cnt.get(x)*cnt.get(a-x);
            }
            if (q > 1) System.out.print(" ");
            System.out.print(ans);
        }
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
