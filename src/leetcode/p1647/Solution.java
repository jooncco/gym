package leetcode.p1647;

import java.util.Arrays;

public class Solution {
    private int[] freq;

    public int minDeletions(String s) {
        freq= new int[26];
        int n= s.length();
        for (int i=0; i < n; ++i) ++freq[s.charAt(i)-'a'];
        Arrays.sort(freq);
        int ans= 0;
        boolean[] takenFreq= new boolean[freq[25]+1];
        for (int i=25; i >= 0 && freq[i] > 0; --i) {
            if (takenFreq[freq[i]]) {
                int curFreq= freq[i];
                while (curFreq > 0 && takenFreq[curFreq]) {
                    --curFreq;
                    ++ans;
                }
                takenFreq[curFreq]= true;
            } else {
                takenFreq[freq[i]]= true;
            }
        }
        return ans;
    }
}