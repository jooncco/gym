package codeforces.c1855;
// https://codeforces.com/contest/1855/problem/C2

import java.util.*;
import java.io.*;

/**
 * Constructive, Greedy, Math
 * | Time: O (n)
 * | Space: O (n)
 */
public class C2 {
    private static FastScanner sc = new FastScanner();

    private static String solve() {
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        List<Integer> posIndices = new ArrayList<>(), negIndices = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            a[i] = sc.nextInt();
            if (a[i] > 0)
                posIndices.add(i);
            if (a[i] < 0)
                negIndices.add(i);
        }

        List<int[]> ans = new ArrayList<>();
        if (posIndices.isEmpty()) {
            for (int i = n; i > 1; --i) {
                ans.add(new int[] { i - 1, i });
            }
        } else if (negIndices.isEmpty()) {
            for (int i = 2; i <= n; ++i) {
                ans.add(new int[] { i, i - 1 });
            }
        } else if (negIndices.size() < 8) {
            for (int i = 0; i < 5; ++i) {
                ans.add(new int[] { posIndices.get(0), posIndices.get(0) });
            }
            for (int idx : negIndices) {
                ans.add(new int[] { idx, posIndices.get(0) });
            }
            for (int i = 2; i <= n; ++i) {
                ans.add(new int[] { i, i - 1 });
            }
        } else if (posIndices.size() < 8) {
            for (int i = 0; i < 5; ++i) {
                ans.add(new int[] { negIndices.get(0), negIndices.get(0) });
            }
            for (int idx : posIndices) {
                ans.add(new int[] { idx, negIndices.get(0) });
            }
            for (int i = n; i > 1; --i) {
                ans.add(new int[] { i - 1, i });
            }
        } else {
            int mx = -21, mxIdx = -1;
            int mn = 21, mnIdx = -1;
            for (int i = 1; i <= n; ++i) {
                if (mx < a[i]) {
                    mx = a[i];
                    mxIdx = i;
                }
                if (mn > a[i]) {
                    mn = a[i];
                    mnIdx = i;
                }
            }

            boolean isPositiveDominant = Math.abs(mx) > Math.abs(mn);
            List<Integer> targetIndices = isPositiveDominant ? negIndices : posIndices;
            int strongIdx = isPositiveDominant ? mxIdx : mnIdx;
            for (int idx : targetIndices) {
                ans.add(new int[] { idx, strongIdx });
            }
            if (isPositiveDominant) {
                for (int i = 2; i <= n; ++i) {
                    ans.add(new int[] { i, i - 1 });
                }
            } else {
                for (int i = n; i > 1; --i) {
                    ans.add(new int[] { i - 1, i });
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size());
        if (ans.size() > 0) {
            sb.append("\n");
            for (int i = 0; i < ans.size(); ++i) {
                if (i > 0)
                    sb.append("\n");
                sb.append(ans.get(i)[0] + " " + ans.get(i)[1]);
            }
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