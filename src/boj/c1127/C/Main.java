package boj.c1127.C;
// https://codejam.lge.com/contest/problem/1127/3

import java.util.*;
import java.io.*;

/**
 * Brute Force
 * | Time: O(250000RC)
 * | Space: O(RC)
 */
public class Main {
    private static FastScanner sc = new FastScanner();

    private static void solve() {
        int R= sc.nextInt(), C= sc.nextInt();
        String[] grid= new String[R];
        for (int i= 0; i < R; ++i) grid[i]= sc.next();

        int ans= 0;
        int[][] visited= new int[R][C]; // 0: no, 1: out, 2: can't, 3: not determined
        List<int[]> nodes;
        for (int i=0; i < R; ++i) {
            for (int j=0; j < C; ++j) {
                if (visited[i][j] == 0) {
                    nodes= new ArrayList<>();
                    int[] nxt= new int[]{i, j};
                    for (int k=0; k < 250_000; ++k) {
                        if (nxt[0] == -1 && nxt[1] == -1) break;
                        if (visited[nxt[0]][nxt[1]] > 0) break;
                        visited[nxt[0]][nxt[1]]= 3;
                        nodes.add(nxt);
                        nxt= getNext(R, C, nxt[0], nxt[1], grid[nxt[0]].charAt(nxt[1]));
                    }
                    int result= 0;
                    if (nxt[0] == -1 && nxt[1] == -1) result= 1;
                    else result= visited[nxt[0]][nxt[1]];
                    if (result == 3) result= 2;
                    for (int[] node : nodes) {
                        visited[node[0]][node[1]]= result;
                    }
                    if (result == 1) ans += nodes.size();
                }
            }
        }
        System.out.print(ans);
    }

    private static int[] getNext(int R, int C, int r, int c, char dir) {
        int[] OUT= new int[]{-1,-1};
        switch (dir) {
            case 'D':
                if (r == R-1) return OUT;
                return new int[]{r+1, c};
            case 'U':
                if (r == 0) return OUT;
                return new int[]{r-1, c};
            case 'R':
                if (c == C-1) return OUT;
                return new int[]{r, c+1};
            case 'L':
                if (c == 0) return OUT;
                return new int[]{r, c-1};
        }
        return OUT;
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
            solve();
    }
}