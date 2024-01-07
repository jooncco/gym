package codeforces.c1919;
// https://codeforces.com/contest/1919/problem/D

import java.util.*;
import java.io.*;

/**
 * Data Structures(Trees), Implementation
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class D {
    private static final FastScanner sc = new FastScanner();

    private static void solve() {
        int n= sc.nextInt();
        TreeMap<Integer, Integer> map= new TreeMap<>();
        List<List<Integer>> pos= new ArrayList<>();
        for (int i= 0; i < n; ++i) pos.add(new ArrayList<>());
        for (int i=0; i < n; ++i) {
            int x= sc.nextInt();
            map.put(i, x);
            pos.get(x).add(i);
        }
        for (int i=n-1; i > 0; --i) {
            // remove 'i's in the array
            for (int idx : pos.get(i-1)) {
                var it= map.higherEntry(idx);
                while (it != null && it.getValue() == i) {
                    map.remove(it.getKey());
                    it= map.higherEntry(idx);
                }
                it= map.lowerEntry(idx);
                while (it != null && it.getValue() == i) {
                    map.remove(it.getKey());
                    it= map.lowerEntry(idx);
                }
            }
        }
        System.out.print(map.size() == 1 && map.containsValue(0) ? "yes" : "no");
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
