package codeforces.c1919;
// https://codeforces.com/contest/1919/problem/B

import java.util.*;
import java.io.*;

/**
 * Greedy, Stack
 * | Time: O(n)
 * | Space: O(n)
 */
public class B {
    private static final FastScanner sc = new FastScanner();

    private static void solve() {
        String s= sc.next();
        Stack<Character> stack= new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '+') {
                if (!stack.isEmpty() && stack.peek() == '-') stack.pop();
                else stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '+') stack.pop();
                else stack.push(c);
            }
        }
        System.out.print(stack.size());
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
