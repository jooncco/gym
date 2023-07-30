package codeforces.c1855.B;
// https://codeforces.com/contest/1855/problem/B

import java.io.*;
import java.util.*;

/**
 * Math (Number Theroy)
 * | Time: O (1)
 * | Space: O (1)
 */
public class Main {
    private static FastScanner sc= new FastScanner();

    private static long solve() throws IOException {
        long n= sc.nextLong();
        long ans= 1, curMax= 1;
        for (long i=2; i < 1000; ++i) {
            if (n%i == 0) ++curMax;
            else curMax= 0;
            ans= Math.max(ans, curMax);
        }
        return ans;
    }

    private static class FastScanner {
        private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st= new StringTokenizer("");
        static String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st= new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        int T= sc.nextInt();
        for (int t=1; t <= T; ++t) {
            if (t > 1) sb.append("\n");
            sb.append(solve());
        }
        System.out.print(sb);
    }
}
