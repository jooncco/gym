package codeforces.c1855.D;
// https://codeforces.com/contest/1855/problem/D

import java.util.*;
import java.io.*;

/**
 * Bitmask DP (Knapsack)
 * | Time: O (n^2/w)
 * | Space: O (2*n)
 */
public class Main {
    private static FastScanner sc = new FastScanner();

    private static long solve() {
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            a[i] = sc.nextInt();
        long sum = 0, ans = 0;
        BitSet bs = new BitSet(2 * n + 1);
        bs.set(1);
        for (int i = 1; i <= n; ++i) {
            if (bs.get(i))
                ans = Math.max(ans, sum + a[i] - i + 1);
            BitSet tmp = bs.clone();
            tmp.leftShift(a[i]);
            bs.or(tmp);
            bs.clear(i);
            sum += a[i];
        }
        for (int i = n + 1; i <= 2 * n; ++i) {
            if (bs.get(i))
                ans = Math.max(ans, sum - i + 1);
        }
        return ans;
    }

    static class BitSet implements Serializable, Cloneable {
        private long[] data;
        private long tailAvailable;
        private int totalBit;
        private int m;
        private static final int SHIFT = 6;
        private static final int LOW = 63;
        private static final int BITS_FOR_EACH = 64;
        private static final long ALL_ONE = ~0L;
        private static final long ALL_ZERO = 0L;
        private static final int MAX_OFFSET = 63;

        BitSet(int n) {
            totalBit = n;
            this.m = (totalBit + 64 - 1) / 64;
            data = new long[m];
            tailAvailable = oneBetween(0, offset(totalBit - 1));
        }

        BitSet(BitSet bs) {
            this.data = bs.data.clone();
            this.tailAvailable = bs.tailAvailable;
            this.totalBit = bs.totalBit;
            this.m = bs.m;
        }

        BitSet(BitSet bs, int l, int r) {
            totalBit = r - l + 1;
            tailAvailable = oneBetween(0, offset(totalBit - 1));
            data = Arrays.copyOfRange(bs.data, word(l), word(r) + 1);
            this.m = data.length;
            leftShift(offset(l));
            this.m = (totalBit + 64 - 1) / 64;
            data[m - 1] &= tailAvailable;
            for (int i = m; i < data.length; i++) {
                data[i] = 0;
            }
        }

        boolean get(int i) {
            return (data[word(i)] & (1L << offset(i))) != 0;
        }

        void set(int i) {
            data[word(i)] |= (1L << offset(i));
        }

        void clear(int i) {
            data[word(i)] &= ~(1L << offset(i));
        }

        void flip(int i) {
            data[word(i)] ^= (1L << offset(i));
        }

        private static int word(int i) {
            return i >>> SHIFT;
        }

        private static int offset(int i) {
            return i & LOW;
        }

        private long oneBetween(int l, int r) {
            if (r < l) {
                return 0;
            }
            long lBegin = 1L << offset(l);
            long rEnd = 1L << offset(r);
            return (ALL_ONE ^ (lBegin - 1)) & ((rEnd << 1) - 1);
        }

        int capacity() {
            return totalBit;
        }

        void copy(BitSet bs) {
            int n = Math.min(this.m, bs.m);
            System.arraycopy(bs.data, 0, data, 0, n);
            Arrays.fill(data, n, n, 0);
        }

        void or(BitSet bs) {
            int n = Math.min(this.m, bs.m);
            for (int i = 0; i < n; i++) {
                data[i] |= bs.data[i];
            }
        }

        int findFirst() {
            for (int i = 0; i < m; i++) {
                if (data[i] != 0L) {
                    return i * 64 + ffs(data[i]) - 1;
                }
            }
            return -1;
        }

        int nextSetBit(int start) {
            int offset = offset(start);
            int w = word(start);
            if (offset != 0) {
                long mask = oneBetween(offset, 63);
                if ((data[w] & mask) != 0) {
                    return Long.numberOfTrailingZeros(data[w] & mask) + w * BITS_FOR_EACH;
                }
                w++;
            }

            while (w < m && data[w] == ALL_ZERO) {
                w++;
            }
            if (w >= m) {
                return capacity();
            }
            return Long.numberOfTrailingZeros(data[w]) + w * BITS_FOR_EACH;
        }

        void rightShift(int n) {
            int wordMove = word(n);
            int offsetMove = offset(n);
            int rshift = 63 - (offsetMove - 1);

            if (offsetMove != 0) {
                for (int i = 0; i < m; i++) {
                    if (i > 0) {
                        data[i - 1] |= data[i] << rshift;
                    }
                    data[i] >>>= offsetMove;
                }
            }
            if (wordMove > 0) {
                for (int i = 0; i < m; i++) {
                    if (i >= wordMove) {
                        data[i - wordMove] = data[i];
                    }
                    data[i] = 0;
                }
            }
        }

        void leftShift(int n) {
            int wordMove = word(n);
            int offsetMove = offset(n);
            int lShift = MAX_OFFSET + 1 - offsetMove;

            if (offsetMove != 0) {
                for (int i = m - 1; i >= 0; i--) {
                    if (i + 1 < m) {
                        data[i + 1] |= data[i] >>> lShift;
                    }
                    data[i] <<= offsetMove;
                }
            }
            if (wordMove > 0) {
                for (int i = m - 1; i >= 0; i--) {
                    if (i + wordMove < m) {
                        data[i + wordMove] = data[i];
                    }
                    data[i] = 0;
                }
            }

            data[m - 1] &= tailAvailable;
        }

        private int ffs(long x) {
            if (x == 0)
                return 0;
            int num = 1;
            if ((x & 0xffffffffL) == 0) {
                num += 32;
                x >>= 32;
            }
            if ((x & 0xffff) == 0) {
                num += 16;
                x >>= 16;
            }
            if ((x & 0xff) == 0) {
                num += 8;
                x >>= 8;
            }
            if ((x & 0xf) == 0) {
                num += 4;
                x >>= 4;
            }
            if ((x & 0x3) == 0) {
                num += 2;
                x >>= 2;
            }
            if ((x & 0x1) == 0) {
                num += 1;
            }
            return num;
        }

        public BitSet clone() {
            return new BitSet(this);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder("{");
            for (long datum : data) {
                builder.append(Long.toBinaryString(datum)).append(", ").append(datum);
            }
            builder.append("}");
            return builder.toString();
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(
                        new FileReader("input.txt"));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }

    public static void main(String[] args) {
        System.out.print(solve());
    }
}
