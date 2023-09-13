package boj.c1127.A;

import java.util.*;
import java.io.*;

public class Main {
    private static FastScanner sc = new FastScanner();
    private static int ans= 0;
    private static int[][][] quality;
    private static char[][][] color;

    private static void solve() {
        int n= sc.nextInt();
        quality= new int[n][4][4];
        color= new char[n][4][4];
        for (int i= 0; i < n; ++i) {
            for (int j= 0; j < 4; ++j) {
                for (int k= 0; k < 4; ++k) {
                    quality[i][j][k]= sc.nextInt();
                }
            }
            for (int j= 0; j < 4; ++j) {
                for (int k= 0; k < 4; ++k) {
                    color[i][j][k]= sc.next().charAt(0);
                }
            }
        }

        dfs(n, new int[5][5], 0, 0, 3);
        System.out.print(ans);
    }

    private static void rotate90(int[][] quality) {
        
    }

    private static void rotate90(char[][] color) {
        
    }

    private static void dfs(int n, int[][] gama, int mask, int curIdx, int cnt) {
        if (cnt == 0) {
            ans= Math.max(ans, compute(gama));
            return;
        }
        if (curIdx == n) return;

        for (int i=0; i < n; ++i) {
            if ((mask&(1<<i)) == 0 && cnt > 0) {
                for (int j= 0; j < 2; ++j) {
                    for (int k= 0; k < 2; ++k) {
                        dfs(n, apply(gama, quality[i], color[i], j, k), mask|(1<<i), curIdx+1, cnt-1);
                    }
                }
            }
        }
    }

    private static int[][] apply(int[][] gama, int[][] quality, char[][] color, int r, int c) {
        int[][] ret= new int[5][5];
        for (int i=0; i < 5; ++i) {
            for (int j= 0; j < 5; ++j) {
                ret[i][j]= gama[i][j];
            }
        }

        // quality
        for (int i=0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                ret[r+i][c+j] += quality[i][j];
                if (ret[r+i][c+j] < 0) ret[r+i][c+j]= 0;
                if (ret[r+i][c+j] > 9) ret[r+i][c+j]= 9;
            }
        }

        // color
        for (int i= 0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                if (color[i][j] == 'W') continue;
                ret[r+i][c+j]= color[i][j];
            }
        }
        return ret;
    }

    private static int compute(int[][] gama) {
        int r= 0, g= 0, b= 0, y= 0;
        for (int i= 0; i < 5; ++i) {
            for (int j= 0; j < 5; ++j) {
                if (gama[i][j] == 'R') ++r;
                if (gama[i][j] == 'G') ++g;
                if (gama[i][j] == 'B') ++b;
                if (gama[i][j] == 'Y') ++y;
            }
        }
        return 7*r + 5*b + 3*g + 2*y;
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