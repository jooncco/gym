package boj.p24840;
// https://www.acmicpc.net/problem/24840

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Greedy
 * | Time: O (log n)
 * | Space: O (1)
 */
public class Main {
    private static String solve() throws IOException {
        String N= Sc.next();
        int n= N.length();
        int sum= 0;
        for (char c : N.toCharArray()) sum += c-'0';

        int numForInsert= (9-sum%9)%9;
        if (numForInsert == 0) {
            return N.substring(0, 1) + numForInsert + N.substring(1);
        }
        int idx= 0;
        while (idx < n) {
            if (N.charAt(idx)-'0' > numForInsert) break;
            ++idx;
        }
        return N.substring(0, idx) + numForInsert + N.substring(idx);
    }

    private static class Sc {
        private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st= new StringTokenizer("");
        static String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st= new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        int T= Sc.nextInt();
        for (int t=1; t <= T; ++t) {
            if (t > 1) sb.append("\n");
            sb.append("Case #").append(t).append(": ");
            sb.append(solve());
        }
        System.out.print(sb);
    }
}