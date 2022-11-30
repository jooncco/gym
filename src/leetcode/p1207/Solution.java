package leetcode.p1207;
// https://leetcode.com/problems/unique-number-of-occurrences/

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        final int OFFSET= 1000;
        int[] cnt= new int[2001];
        for (int num : arr) cnt[num+OFFSET]++;
        boolean[] countOccurrence= new boolean[1001];
        for (int i=0; i <= OFFSET+1000; ++i) {
            if (cnt[i] > 0 && countOccurrence[cnt[i]]) return false;
            countOccurrence[cnt[i]]= true;
        }
        return true;
    }
}