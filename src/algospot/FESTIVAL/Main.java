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
    private static final int INF= 987654321;

    private static void solve() {
        int n= sc.nextInt(), L= sc.nextInt();
        int[] a= new int[n+1];
        for (int i= 1; i <= n; ++i) {
            a[i]= sc.nextInt();
        }
        int[] cumSum= new int[n+1];
        for (int i=1; i <= n; ++i) {
            cumSum[i]= cumSum[i-1]+a[i];
        }
        
        double ans= INF;
        for (int i=1; i <= n; ++i) {
            for (int j=i+L-1; j <= n; ++j) {
                ans= Math.min(ans, (cumSum[j]-cumSum[i-1])*1.0/(j-i+1));
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
