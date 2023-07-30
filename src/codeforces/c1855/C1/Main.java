package codeforces.c1855.C1;
// https://codeforces.com/contest/1855/problem/C1

import java.io.*;
import java.util.*;

/**
 * Math (Number Theory)
 * | Time: O (n)
 * | Space: O (n)
 */
public class Main {
    private static FastScanner sc= new FastScanner();

    private static String solve() throws IOException {
        int n= sc.nextInt();
        int[] arr= new int[n];
        for (int i=0; i < n; ++i) arr[i]= sc.nextInt();

        List<int[]> ops= new ArrayList<>();
        int firstPositiveIdx= n;
        for (int i=0; i < n; ++i) {
            if (arr[i] > 0) {
                firstPositiveIdx= i;
                break;
            }
        }
        if (firstPositiveIdx < n-1) {
            while (arr[firstPositiveIdx] <= 20) {
                ops.add(new int[]{firstPositiveIdx, firstPositiveIdx});
                arr[firstPositiveIdx] *= 2;
            }
            int idx= firstPositiveIdx;
            while (idx < n-1) {
                while (arr[idx+1] < arr[idx]) {
                    ops.add(new int[]{idx+1, idx});
                    arr[idx+1] += arr[idx];
                }
                ++idx;
            }
        }
        if (firstPositiveIdx > 1) {
            int lIdx= firstPositiveIdx-1;
            while (lIdx >= 0 && arr[lIdx] == 0) --lIdx;
            while (lIdx > 0 && arr[lIdx] > -20) {
                ops.add(new int[]{lIdx, lIdx});
                arr[lIdx] *= 2;
            }
            while (lIdx > 0) {
                while (arr[lIdx-1] > arr[lIdx]) {
                    ops.add(new int[]{lIdx-1, lIdx});
                    arr[lIdx-1] += arr[lIdx];
                }
                --lIdx;
            }
        }

        StringBuilder sb= new StringBuilder();
        sb.append(ops.size());
        if (ops.size() > 0) sb.append("\n");
        for (int i=0; i < ops.size(); ++i) {
            if (i > 0) sb.append("\n");
            sb.append((ops.get(i)[0]+1) + " " + (ops.get(i)[1]+1));
        }
        return sb.toString();
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
