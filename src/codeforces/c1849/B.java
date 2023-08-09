package codeforces.c1849;
// https://codeforces.com/contest/1849/problem/B

import java.io.*;
import java.util.*;

/**
 * Math(Modular), Sortings
 * | Time: O (n log n)
 * | Space: O (n)
 */
public class B {
    private static FastScanner sc = new FastScanner();

    private static String solve() throws IOException {
        int n = sc.nextInt(), k = sc.nextInt();
        List<int[]> monsters = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int[] monster = new int[] { sc.nextInt() % k, i + 1 };
            if (monster[0] == 0)
                monster[0] += k;
            monsters.add(monster);
        }
        Collections.sort(monsters, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        StringBuilder sb = new StringBuilder();
        boolean space = false;
        for (int[] monster : monsters) {
            if (space)
                sb.append(" ");
            sb.append(monster[1]);
            if (!space)
                space = true;
        }
        return sb.toString();
    }

    private static class FastScanner {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");

        static String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
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