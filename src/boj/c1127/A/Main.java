package boj.c1127.A;
// https://codejam.lge.com/contest/problem/1127/1

import java.util.*;
import java.io.*;

/**
 * Implementation
 * | Time: O(16n + 16n^3)
 * | Space: O(n)
 */
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

        dfs(n, new int[5][5], new char[5][5], 0, 3);
        System.out.print(ans);
    }

    private static void rotate90(int[][] quality) {
        int[][] buf= new int[4][4];
        for (int i=0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                buf[j][3-i]= quality[i][j];
            }
        }
        for (int i=0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                quality[i][j]= buf[i][j];
            }
        }
    }

    private static void rotate90(char[][] color) {
        char[][] buf= new char[4][4];
        for (int i=0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                buf[j][3-i]= color[i][j];
            }
        }
        for (int i=0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                color[i][j]= buf[i][j];
            }
        }
    }

    private static void dfs(int n, int[][] gamaQ, char[][] gamaC, int mask, int cnt) {
        if (cnt == 0) {
            ans= Math.max(ans, compute(gamaQ, gamaC));
            return;
        }

        for (int i=0; i < n; ++i) {
            if ((mask&(1<<i)) == 0) {
                for (int j= 0; j < 2; ++j) {
                    for (int k= 0; k < 2; ++k) {
                        for (int l= 0; l < 4; ++l) {
                            rotate90(quality[i]);
                            rotate90(color[i]);
                            dfs(n, apply(gamaQ, quality[i], j, k), apply(gamaC, color[i], j, k), mask|(1<<i), cnt-1);
                        }
                    }
                }
            }
        }
    }

    private static int[][] apply(int[][] gamaQ, int[][] quality, int r, int c) {
        int[][] ret= new int[5][5];
        for (int i=0; i < 5; ++i) {
            for (int j= 0; j < 5; ++j) {
                ret[i][j]= gamaQ[i][j];
            }
        }

        for (int i=0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                ret[r+i][c+j] += quality[i][j];
                if (ret[r+i][c+j] < 0) ret[r+i][c+j]= 0;
                if (ret[r+i][c+j] > 9) ret[r+i][c+j]= 9;
            }
        }
        return ret;
    }

    private static char[][] apply(char[][] gamaC, char[][] color, int r, int c) {
        char[][] ret= new char[5][5];
        for (int i=0; i < 5; ++i) {
            for (int j= 0; j < 5; ++j) {
                ret[i][j]= gamaC[i][j];
            }
        }
        
        for (int i= 0; i < 4; ++i) {
            for (int j= 0; j < 4; ++j) {
                if (color[i][j] == 'W') continue;
                ret[r+i][c+j]= color[i][j];
            }
        }
        return ret;
    }

    private static int compute(int[][] gamaQ, char[][] gamaC) {
        int r= 0, g= 0, b= 0, y= 0;
        for (int i= 0; i < 5; ++i) {
            for (int j= 0; j < 5; ++j) {
                if (gamaC[i][j] == 'R') r += gamaQ[i][j];
                if (gamaC[i][j] == 'G') g += gamaQ[i][j];
                if (gamaC[i][j] == 'B') b += gamaQ[i][j];
                if (gamaC[i][j] == 'Y') y += gamaQ[i][j];
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