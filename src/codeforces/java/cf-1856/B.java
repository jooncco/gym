package codeforces.c1856;
// https://codeforces.com/contest/1856/problem/B

import java.util.*;
import java.io.*;

/**
 * Constructive Algorithms
 * | Time: O (n)
 * | Space: O (n)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (n == 1)
            return "NO";
        String ans = "YES";
        for (int num : arr) {
            if (num == 1) {
                if (sum < 2) {
                    ans = "NO";
                    break;
                } else
                    sum -= 2;
            } else {
                if (sum < 1) {
                    ans = "NO";
                    break;
                } else
                    --sum;
            }
        }
        return ans;
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
