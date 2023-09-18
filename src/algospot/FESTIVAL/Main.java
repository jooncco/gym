package algospot.FESTIVAL;
// https://www.algospot.com/judge/problem/read/FESTIVAL

import java.util.*;
import java.io.*;

/**
 * Brute Force
 * | Time: O(n^2)
 * | Space: O(n)
 */
public class Main {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt(), l= sc.nextInt();
        int[] arr= new int[n];
        for (int i= 0; i < n; ++i) {
            arr[i]= sc.nextInt();
        }
        double ans= 1000_000;
        for (int i= 0; i <= n-l; ++i) {
            int sum= 0, cnt= 0;
            for (int j= i; j < i+l-1; ++j) {
                sum += arr[j];
                ++cnt;
            }
            for (int j= i+l-1; j < n; ++j) {
                sum += arr[j];
                ++cnt;
                ans= Math.min(ans, sum*1.0/cnt);
            }
        }
        System.out.print(ans);
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
            if (t > 1) System.out.println();
            solve();
        }
    }
}
