package boj.p24839;
// https://www.acmicpc.net/problem/24839

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Two Pointers
 * | Time: O (n+m)
 * | Space: O (n+m)
 */
public class Main {
    private static String solve() throws IOException {
        String I= SC.next(), P= SC.next();
        int ans= 0, r= 0;
        for (int i=0; i < I.length(); ++i) {
            if (r == P.length()) return "IMPOSSIBLE";
            if (I.charAt(i) != P.charAt(r)) {
                --i;
                ++ans;
            }
            ++r;
        }
        ans += P.length()-r;
        return ans+"";
    }

    private static class SC {
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
        int T= SC.nextInt();
        for (int t=1; t <= T; ++t) {
            if (t > 1) sb.append("\n");
            sb.append("Case #").append(t).append(": ");
            sb.append(solve());
        }
        System.out.print(sb);
    }
}