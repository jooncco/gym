package leetcode.p87;
// https://leetcode.com/problems/scramble-string/

public class Solution {
    private int N;
    private String A, B;
    private int[][][] cache;

    public boolean isScramble(String s1, String s2) {
        A= s1;
        B= s2;
        N= s1.length();
        cache= new int[N][N][N+1];
        for (int l=0; l < N; ++l) {
            for (int L=0; L < N; ++L) {
                for (int n=0; n <= N; ++n) {
                    cache[l][L][n]= -1;
                }
            }
        }
        return isScramble(0, 0, N) == 1;
    }

    private int isScramble(int l, int L, int n) {
        String a= A.substring(l, l+n);
        String b= B.substring(L, L+n);
        if (!isAnagram(a, b)) return 0;
        if (n <= 3) return isAnagram(a, b) ? 1 : 0;
        if (cache[l][L][n] > -1) return cache[l][L][n];
        cache[l][L][n]= 0;
        for (int i=1; i < n; ++i) {
            if (isScramble(l, L, i) == 1 && isScramble(l+i, L+i, n-i) == 1) {
                cache[l][L][n]= 1;
            }
            if (isScramble(l, L+n-i, i) == 1 && isScramble(l+i, L, n-i) == 1) {
                cache[l][L][n]= 1;
            }
        }
        return cache[l][L][n];
    }

    private boolean isAnagram(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        int[] charCount= new int[26];
        for (char c : a.toCharArray()) {
            ++charCount[c-'a'];
        }
        for (char c : b.toCharArray()) {
            if (charCount[c-'a'] < 1) return false;
            --charCount[c-'a'];
        }
        return true;
    }
}