package codeforces.c1856;
// https://codeforces.com/contest/1856/problem/C

import java.util.*;
import java.io.*;

/**
 * Binary Search
 * | Time: O (n^2)
 * | Space: O (n)
 */
public class C {
    private static FastScanner sc = new FastScanner();

    private static int solve() {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        int l = 1, r = (int) 1e9;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isPossible(n, arr, m, k))
                l = m + 1;
            else
                r = m;
        }
        return l - 1;
    }

    private static boolean isPossible(int n, int[] arr, int goal, int k) {
        for (int i = 0; i < n; ++i) {
            int have = k;
            for (int j = i; j < n; ++j) {
                int required = goal - (j - i);
                if (required <= arr[j])
                    return true;
                int need = required - arr[j];
                if (have < need)
                    break;
                have -= need;
            }
        }
        return false;
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
