package codeforces.c1849.A;

import java.io.*;
import java.util.*;

public class Solution {
    private static FastScanner sc= new FastScanner();

    private static int solve() throws IOException {
        int b= sc.nextInt(), c= sc.nextInt(), h= sc.nextInt();
        return 1 + 2*Math.min(b-1, (c+h));
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