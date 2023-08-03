package boj.p3273;
// https://www.acmicpc.net/problem/3273

import java.util.*;
import java.io.*;

/**
 * Sorting, Two Pointsers
 * | Time: O (n)
 * | Space: O (n)
 */
public class Main {
    private static FastScanner sc = new FastScanner();

    private static int solve() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int x = sc.nextInt();

        int idx = findIdx(arr, x);
        if (arr[idx] >= x)
            --idx;
        if (idx < 0)
            return 0;

        int ans = 0;
        int l = 0, r = idx;
        while (l < r) {
            if (arr[l] + arr[r] == x) {
                ++ans;
                ++l;
                --r;
            } else if (arr[l] + arr[r] > x)
                --r;
            else
                ++l;
        }
        return ans;
    }

    private static int findIdx(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
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
        System.out.print(solve());
    }
}