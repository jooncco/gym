package codeforces.c1919;
// https://codeforces.com/contest/1919/problem/C

import java.util.*;
import java.io.*;

/**
 * Greedy, Data Structures
 * | Time: O(n)
 * | Space: O(1)
 */
public class C {
    private static final FastScanner sc = new FastScanner();

    private static void solve() {
        final int INF= 987654321;
        int n= sc.nextInt();
        int ans= 0;
        int[] tail= new int[]{INF, INF};
        for (int i= 0; i < n; ++i) {
            int num= sc.nextInt();
            if (num <= tail[1]) {
                tail[1]= num;
            } else if (num <= tail[0]) {
                tail[0]= num;
            } else {
                ++ans;
                tail[1]= tail[0];
                tail[0]= num;
            }
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
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            if (t > 1)
                System.out.println();
            solve();
        }
    }
}