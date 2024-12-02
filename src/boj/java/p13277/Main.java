package boj.p13277;
// https://www.acmicpc.net/problem/13277

import java.util.*;
import java.io.*;

/**
 * Divide And Conquer
 * | Time: O(n^log3)
 * | Space: O(1.5n log(n))
 */
public class Main {
    private static final FastScanner sc = new FastScanner();

    private static void solve() {
        String a= sc.next(), b= sc.next();
        StringBuilder sb= new StringBuilder();
        for (int d : multiply(a, b)) {
            sb.append(d);
        }
        System.out.print(sb.reverse().toString());
    }

    /**
     * Computes (a*b). Implements karatsuba algorithm.
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> multiply(String a, String b) {
        List<Integer> aList= new ArrayList<>(a.length());
        for (int i= a.length()-1; i >= 0; --i) {
            aList.add(a.charAt(i)-'0');
        }
        List<Integer> bList= new ArrayList<>(b.length());
        for (int i= b.length()-1; i >= 0; --i) {
            bList.add(b.charAt(i)-'0');
        }
        return multiply(aList, bList);
    }

    /**
     * Computes (a*b). Implements karatsuba algorithm.
     * @param a
     * @param b
     * @return
     */
    private static List<Integer> multiply(List<Integer> a, List<Integer> b) {
        int an= a.size(), bn= b.size();
        if (an < bn) return multiply(b, a);
        
        if (an == 0 && bn == 0) return List.of(0);
        if (bn == 0) return a;
        if (an <= 50) {
            // Naive multiplication is faster in this case.
            List<Integer> ret= new ArrayList<>(an+bn);
            for (int i= 0; i <= an+bn; ++i) {
                ret.add(0);
            }
            for (int i= 0; i < bn; ++i) {
                for (int j= 0; j < an; ++j) {
                    ret.set(i+j, ret.get(i+j) + b.get(i)*a.get(j));
                }
            }
            for (int i= 0; i < an+bn; ++i) {
                ret.set(i+1, ret.get(i+1) + ret.get(i)/10);
                ret.set(i, ret.get(i)%10);
            }
            while (ret.get(ret.size()-1) == 0) ret.remove(ret.size()-1);
            return ret;
        }

        int half= (an+1)/2;
        List<Integer> a0= new ArrayList<>(a.subList(0, half));
        List<Integer> a1= new ArrayList<>(a.subList(half, an));

        List<Integer> b0= new ArrayList<>(b.subList(0, Math.min(bn, half)));
        List<Integer> b1= new ArrayList<>(b.subList(Math.min(bn, half), bn));

        List<Integer> z0= multiply(a0, b0);
        List<Integer> z1= multiply(a1, b1);
        addTo(a0, a1, 0);
        addTo(b0, b1, 0);
        List<Integer> z2= multiply(a0, b0);
        subtractFrom(z2, z0);
        subtractFrom(z2, z1);
        List<Integer> ret= new ArrayList<>(an+bn);
        for (int i= 0; i < an+bn; ++i) {
            ret.add(0);
        }
        addTo(ret, z1, 2*half);
        addTo(ret, z2, half);
        addTo(ret, z0, 0);
        return ret;
    }

    /**
     * Computes (a + b*10^p)
     * @param a
     * @param b
     * @param p
     */
    private static void addTo(List<Integer> a, List<Integer> b, int p) {
        for (int i= 0; i < p; ++i) b.add(0, 0);
        int an= a.size(), bn= b.size();
        while (an < bn) {
            a.add(0);
            ++an;
        }
        a.add(0);
        for (int i= 0; i < an; ++i) {
            if (i >= bn) break;
            a.set(i+1, a.get(i+1) + (a.get(i) + b.get(i))/10);
            a.set(i, (a.get(i) + b.get(i))%10);
        }
        while (a.size() > 1 && a.get(a.size()-1) == 0) a.remove(a.size()-1);
    }

    /**
     * Computes (a-b). This method assumes a >= b.
     * @param a
     * @param b
     */
    private static void subtractFrom(List<Integer> a, List<Integer> b) {
        int bn= b.size();
        for (int i= 0; i < bn; ++i) {
            if (a.get(i) < b.get(i)) {
                int idx= i+1;
                while (a.get(idx) == 0) {
                    a.set(idx, 9);
                    ++idx;
                }
                a.set(idx, a.get(idx)-1);
                a.set(i, a.get(i)+10);
            }
            a.set(i, a.get(i)-b.get(i));
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
        solve();
    }
}