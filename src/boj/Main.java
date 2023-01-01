package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final static FastScanner sc= new FastScanner();
    private static int t;

    public static void main(String[] args) throws IOException {
        t= sc.nextInt();
        while (t-- > 0) {

        }
    }
}

class FastScanner {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer("");
    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st= new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}