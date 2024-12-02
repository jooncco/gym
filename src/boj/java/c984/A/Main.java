package boj.c984.A;
// https://codejam.lge.com/contest/problem/984/1

import java.util.*;
import java.io.*;

/**
 * Back Tracking
 * | Time: O(n!)
 * | Space: O(log(n!))
 */
public class Main {
    private static FastScanner sc = new FastScanner();
    private static List<String> candidates;

    private static void solve() {
        candidates= new ArrayList<>();
        String S= sc.next();
        String[] grid= new String[3];
        for (int i=0; i < 3; ++i) grid[i]= sc.next();
        int[] idx= new int[26];
        for (char c : S.toCharArray()) {
            int i, j;
            for (i= 0; i < 3; ++i) {
                for (j= 0; j < 3; ++j) {
                    if (grid[i].charAt(j) == c) {
                        idx[c-'A']= i*3+j;
                    }
                }
            }
        }

        String T= t(S, idx);
        find(S, T, grid, 0, 0, "");
        Collections.sort(candidates);
        System.out.print(T + " " + candidates.get(0));
    }

    private static void find(String S, String T, String[] grid, int gridMask, int curIdx, String str) {
        if (curIdx == S.length()) {
            candidates.add(str);
            return;
        }
        
        for (int i= 0; i < 9; ++i) {
            if ((gridMask & (1<<i)) == 0 && 
                T.charAt(curIdx)-'0' == score(gridMask|(1<<i), i)) {
                String nextStr= str + grid[i/3].charAt(i%3);
                find(S, T, grid, gridMask|(1<<i), curIdx+1, nextStr);
            }
        }
    }

    private static String t(String S, int[] idx) {
        int gridMask= 0;
        StringBuilder sb= new StringBuilder();
        for (char c : S.toCharArray()) {
            gridMask |= (1<<idx[c-'A']);
            sb.append(score(gridMask, idx[c-'A']));
        }
        return sb.toString();
    }

    private static int score(int grid, int target) {
        int totalScore= 0;
        if ((7&(1<<target)) == (1<<target) && (grid&7) == 7) {
            ++totalScore;
        }
        if (((7<<3)&(1<<target)) == (1<<target) && (grid&(7<<3)) == (7<<3)) {
            ++totalScore;
        }
        if (((7<<6)&(1<<target)) == (1<<target) && (grid&(7<<6)) == (7<<6)) {
            ++totalScore;
        }
        if ((73&(1<<target)) == (1<<target) && (grid&73) == 73) {
            ++totalScore;
        }
        if (((73<<1)&(1<<target)) == (1<<target) && (grid&(73<<1)) == (73<<1)) {
            ++totalScore;
        }
        if (((73<<2)&(1<<target)) == (1<<target) && (grid&(73<<2)) == (73<<2)) {
            ++totalScore;
        }
        if ((273&(1<<target)) == (1<<target) && (grid&273) == 273) {
            ++totalScore;
        }
        if ((84&(1<<target)) == (1<<target) && (grid&84) == 84) {
            ++totalScore;
        }
        return totalScore;
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
            if (t > 1)
                System.out.println();
            solve();
        }
    }
}