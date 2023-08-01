package boj.p25085;
// https://www.acmicpc.net/problem/25085

import java.util.*;
import java.io.*;

/**
 * Math
 * | Time: O (log R)
 * | Space: O (1)
 */
public class Main {
    private static FastScanner sc = new FastScanner();

    private static double solve() {
        int R = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        List<Integer> radius = new ArrayList<>();
        int r = R;
        boolean left = true;
        while (r > 0) {
            radius.add(r);
            if (left) {
                r *= A;
                left = false;
            } else {
                r /= B;
                left = true;
            }
        }
        double ans = 0;
        for (int ra : radius) {
            ans += 3.1415927 * ra * ra;
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
            sb.append("Case #" + t + ": ");
            sb.append(solve());
        }
        System.out.print(sb);
    }
}