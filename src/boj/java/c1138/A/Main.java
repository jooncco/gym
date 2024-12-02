package boj.c1138.A;

import java.util.*;
import java.io.*;

public class Main {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int N= sc.nextInt(), K= sc.nextInt();
        List<Integer> pos= new ArrayList<>();
        List<Integer> neg= new ArrayList<>();
        for (int i= 0; i < N; ++i) {
            int x= sc.nextInt();
            if (x >= 0) pos.add(x);
            else neg.add(-x);
        }
        Collections.sort(pos);
        Collections.sort(neg);
        long ans= 0;
        int idx= pos.size()-1;
        while (idx >= 0) {
            ans += 2*pos.get(idx);
            idx -= K;
        }
        idx= neg.size()-1;
        while (idx >= 0) {
            ans += 2*neg.get(idx);
            idx -= K;
        }
        System.out.print(ans);
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
