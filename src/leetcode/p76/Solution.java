package leetcode.p76;
// https://leetcode.com/problems/minimum-window-substring/

public class Solution {
    public String minWindow(String s, String t) {
        int[] target= new int[58];
        for (char c : t.toCharArray()) ++target[c-'A'];

        int n= s.length(), l= 0, r= 0;
        int[] source= new int[58];
        int minLength= n, ansL= -1, ansR= -1;
        while (r < n) {
            ++source[s.charAt(r)-'A'];
            while (!covers(source, target) && ++r < n) ++source[s.charAt(r)-'A'];
            while (l < r) {
                --source[s.charAt(l)-'A'];
                if (!covers(source, target)) { ++source[s.charAt(l)-'A']; break; }
                ++l;
            }
            if (r-l+1 <= minLength) { minLength= r-l+1; ansL= l; ansR= r; }
            ++r;
        }
        return ansL < 0 ? "" : s.substring(ansL, ansR+1);
    }

    private boolean covers(int[] source, int[] target) {
        for (int i=0; i < 58; ++i) {
            if (source[i] < target[i]) return false;
        }
        return true;
    }
}