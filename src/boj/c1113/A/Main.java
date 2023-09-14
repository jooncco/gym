package boj.c1113.A;

import java.util.*;
import java.io.*;

public class Main {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt(), pa= sc.nextInt(), pb= sc.nextInt();
        if (pa > pb) {
            int tmp= pa;
            pa= pb;
            pb= tmp;
        }
        int[] x= new int[n];
        for (int i= 0; i < n; ++i) x[i]= sc.nextInt();
        Arrays.sort(x);

        long da= 0, db= 0;
        for (int p : x) {
            da += 2*Math.abs(p-pa);
        }
        long mnSum= da, mnDif= da;
        for (int i=n-1; i >= 0; --i) {
            da -= 2*Math.abs(pa-x[i]);
            db += 2*Math.abs(pb-x[i]);
            if (mnSum > da+db) {
                mnSum= da+db;
                mnDif= Math.abs(da-db);
            }
            if (mnSum == da+db) {
                mnDif= Math.min(mnDif, Math.abs(da-db));
            }
        }
        System.out.print(mnSum + " " + mnDif);
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