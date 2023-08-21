package codeforces.c1857;
// https://codeforces.com/contest/1857/problem/B

import java.util.*;
import java.io.*;

/**
 * Implementation
 * | Time: O (log(n))
 * | Space: O (n)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        String str = sc.next();
        char[] num = str.toCharArray();
        int carry = 0, lastIdx = num.length;
        for (int i = num.length - 1; i >= 0; --i) {
            if (num[i] - '0' + carry >= 5) {
                num[i] = '0';
                carry = 1;
                lastIdx = i;
            } else {
                num[i] = (char) (num[i] + carry);
                carry = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (carry > 0)
            sb.append("1");
        for (int i = 0; i < num.length; ++i) {
            sb.append(lastIdx <= i ? '0' : num[i]);
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