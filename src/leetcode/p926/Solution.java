package leetcode.p926;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int n= s.length();
        List<Integer> pivots= new LinkedList<>();
        int zeros= 0, ones= 0;
        for (int i=1; i < n; ++i) {
            if (s.charAt(i-1) == '0' && s.charAt(i) == '1') pivots.add(i);
            if (s.charAt(i) == '0') ++zeros;
            if (s.charAt(i) == '1') ++ones;
        }
        if (pivots.isEmpty()) return 0;

        int[] one= new int[n]; // minimum flips needed to make all bits '1' of idx >= i
        one[n-1]= s.charAt(n-1) == '0' ? 1 : 0;
        for (int i=n-2; i >= 0; --i) {
            one[i]= s.charAt(i) == '0' ? one[i+1]+1 : one[i+1];
        }
        int[] zero= new int[n]; // minimum flips needed to make all bits '0' of idx < i
        zero[0]= 0;
        for (int i=1; i < n; ++i) {
            zero[i]= s.charAt(i-1) == '1' ? zero[i-1]+1 : zero[i-1];
        }
        int ans= Math.min(zeros, ones);  // base cases
        for (int pivot : pivots) {
            ans= Math.min(ans, zero[pivot]+one[pivot]);
        }
        return ans;
    }
}