package codeforces.c1849.C;
// https://codeforces.com/contest/1849/problem/C

import java.io.*;
import java.util.*;

/**
 * Dynamic Programming, Hashing
 * | Time: O (n + m log(m))
 * | Space: O (n + m)
 */
public class Main {
    private static FastScanner sc= new FastScanner();

    private static int solve() throws IOException {
        int n= sc.nextInt(), m= sc.nextInt();
        String str= sc.next();

        int[] nz= new int[n];
        nz[0]= str.charAt(0) == '0' ? 0 : -1;
        for (int i=1; i < n; ++i) nz[i]= str.charAt(i) == '0' ? i : nz[i-1];
        int[] no= new int[n];
        no[n-1]= str.charAt(n-1) == '1' ? n-1 : n;
        for (int i=n-2; i >= 0; --i) no[i]= str.charAt(i) == '1' ? i : no[i+1];

        Set<String> set= new HashSet<>();
        while (m-- > 0) {
            int l= sc.nextInt()-1, r= sc.nextInt()-1;
            if (nz[r] < no[l]) set.add("degenerate");
            else set.add(nz[r] + "," + no[l]);
        }
        return set.size();
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