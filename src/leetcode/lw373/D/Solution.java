package leetcode.lw373.D;

public class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n= s.length();
        int[] vCnt= new int[n+1];
        for (int i= 1; i <= n; ++i) {
            vCnt[i]= vCnt[i-1];
            if (isVowel(s.charAt(i-1))) ++vCnt[i];
        }

        int ans= 0;
        for (int i=2; i <= n; ++i) {
            int l= i-2;
            while (l >= 0) {
                int totalVowels= vCnt[i]-vCnt[l];
                if ((totalVowels*2 == i-l && totalVowels*totalVowels%k == 0)) ++ans;
                l -= 2;
            }
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }
}