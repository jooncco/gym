package codeforces.c1857;
// https://codeforces.com/contest/1857/problem/E

import java.util.*;
import java.io.*;

/**
 * Math, Sortings
 * | Time: O (nlog(n))
 * | Space: O (n)
 */
public class E {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        int n = sc.nextInt();
        List<int[]> arr = new ArrayList<>();
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int xi = sc.nextInt();
            mn = Math.min(mn, xi);
            mx = Math.max(mx, xi);
            arr.add(new int[] { xi, i });
        }
        arr.sort((a, b) -> a[0] - b[0]);
        long[] ans = new long[n];
        int firstIdx = arr.get(0)[1];
        for (int[] x : arr)
            ans[firstIdx] += (x[0] - mn + 1);
        for (int i = 1; i < n; ++i) {
            int val = arr.get(i)[0], idx = arr.get(i)[1];
            int prevIdx = arr.get(i - 1)[1];
            long diff = val - arr.get(i - 1)[0];
            ans[idx] = ans[prevIdx] + i * diff - (n - i) * diff;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (i > 0)
                sb.append(" ");
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            if (t > 1)
                sb.append("\n");
            sb.append(solve());
        }
        System.out.print(sb);
    }
}