package algospot.BOGGLE;
// https://algospot.com/judge/problem/read/BOGGLE

import java.util.*;
import java.io.*;

/**
 * DP
 * | Time: O(25n)
 * | Space: O(n)
 */
public class Main {
    private static FastScanner sc = new FastScanner();
    private static final int[] dy= {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dx= {-1, 0, 1, -1, 1, -1, 0, 1};
    private static char[][] grid;
    private static int[][][] cc;
    
    private static void solve() {
        grid= new char[5][5];
        for (int i=0; i < 5; ++i) {
            grid[i]= sc.next().toCharArray();
        }
        int Q= sc.nextInt();
        while (Q-- > 0) {
            String target= sc.next();
            int n= target.length();
            cc= new int[5][5][n];
            for (int i= 0; i < 5; ++i) {
                for (int j= 0; j < 5; ++j) {
                    for (int l= 0; l < n; ++l) {
                        cc[i][j][l]= -1;
                    }
                }
            }

            boolean yes= false;
            for (int i= 0; i < 5; ++i) {
                for (int j= 0; j < 5; ++j) {
                    if (grid[i][j] == target.charAt(0)) {
                        boolean isExist= dfs(i, j, target, target.length(), 0);
                        if (isExist) yes= true;
                    }
                }
            }
            System.out.println(target + " " + (yes ? "YES" : "NO"));
        }
    }

    private static boolean dfs(int r, int c, String target, int n, int idx) {
        if (idx == n-1) return true;
        if (cc[r][c][idx] > -1) return cc[r][c][idx] == 1;

        boolean isExist= false;
        int ny, nx;
        for (int i= 0; i < 8; ++i) {
            ny= r+dy[i]; nx= c+dx[i];
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
            if (grid[ny][nx] != target.charAt(idx+1)) continue;
            if (dfs(ny, nx, target, n, idx+1)) {
                isExist= true;
                break;
            }
        }
        cc[r][c][idx]= isExist ? 1 : 0;
        return isExist;
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
            solve();
        }
    }
}