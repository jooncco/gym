package leetcode.p2707;
// https://leetcode.com/problems/extra-characters-in-a-string/

/**
 * DP
 * | Time: O(n^2m)
 * | Space: O(n)
 */
public class Solution {
    private int n;
    private int[] cc;

    public int minExtraChar(String s, String[] dictionary) {
        n= s.length();
        cc= new int[n];
        for (int i= 0; i < n; ++i) cc[i]= -1;
        return minExtraChar(s, dictionary, 0);
    }

    private int minExtraChar(String s, String[] dictionary, int idx) {
        if (idx >= n) return 0;
        if (cc[idx] > -1) return cc[idx];
        
        cc[idx]= n-idx;
        for (String word : dictionary) {
            int len= word.length();
            for (int i=0; idx+i+len <= n; ++i) {
                if (s.substring(idx+i, idx+i+len).equals(word)) {
                    cc[idx]= Math.min(cc[idx], i+minExtraChar(s, dictionary, idx+i+len));
                }
            }
        }
        return cc[idx];
    }
}