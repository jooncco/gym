package algospot.PICNIC;
// https://www.algospot.com/judge/problem/read/PICNIC

import java.util.*;
import java.io.*;

/**
 * DFS (Brute Force)
 * | Time: O(n*n!)
 * | Space: O(n!)
 */
public class Main {
    private static FastScanner sc = new FastScanner();
    private static int ans;

    private static void solve() {
        ans= 0;
        int n= sc.nextInt(), m= sc.nextInt();
        Map<Integer, List<Integer>> friends= new HashMap<>();
        for (int i= 0; i < m; ++i) {
            int a= sc.nextInt(), b= sc.nextInt();
            friends.computeIfAbsent(a, x -> new ArrayList<>()).add(b);
            friends.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
        }
        dfs(n, friends, 0);
        for (int i= 2; i <= n/2; ++i) ans /= i;
        System.out.print(ans);
    }

    private static void dfs(int n, Map<Integer, List<Integer>> friends, int paired) {
        if (paired == (1<<n)-1) {
            ++ans;
            return;
        }

        for (int i=0; i < n; ++i) {
            if ((paired & (1<<i)) == 0 && friends.get(i) != null) {
                for (int friend : friends.get(i)) {
                    if (friend < i) continue;
                    if ((paired & (1<<friend)) == 0) {
                        dfs(n, friends, paired | (1<<i) | (1<<friend));
                    }
                }
            }
        }
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
