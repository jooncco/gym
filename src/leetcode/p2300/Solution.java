package leetcode.p2300;
// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int N= spells.length;
        int M= potions.length;
        int[] pairs= new int[N];
        for (int i=0; i < N; ++i) {
            long minVal= (success+spells[i]-1)/spells[i];
            int l= 0, r= M-1;
            while (l < r) {
                int m= l + (r-l)/2;
                if (potions[m] < minVal) l= m+1;
                else r= m;
            }
            if (spells[i]*1L*potions[l] >= success) --l;
            pairs[i]= M-1-l;
        }
        return pairs;
    }
}