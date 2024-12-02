package codeforces.c1859;
// https://codeforces.com/contest/1859/problem/B

import java.util.*;
import java.io.*;

/**
 * Greedy
 * | Time: O (nm)
 * | Space: O (nm)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static long solve() {
        int n = sc.nextInt();
        int[] mn = new int[n], secondMn = new int[n];
        int theSmallest = Integer.MAX_VALUE;
        int theSecondSmallest = Integer.MAX_VALUE, theSecondSmallestIdx = -1;
        for (int i = 0; i < n; ++i) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; ++j) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            mn[i] = arr[0];
            theSmallest = Math.min(theSmallest, mn[i]);
            secondMn[i] = arr[1];
            if (secondMn[i] < theSecondSmallest) {
                theSecondSmallest = secondMn[i];
                theSecondSmallestIdx = i;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i == theSecondSmallestIdx)
                ans += theSmallest;
            else
                ans += secondMn[i];
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