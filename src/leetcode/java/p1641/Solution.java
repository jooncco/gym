package leetcode.java.p1641;
// https://leetcode.com/problems/count-sorted-vowel-strings/

public class Solution {
    private int ans;

    public int countVowelStrings(int n) {
        ans = 0;
        count(0, n);
        return ans;
    }

    private void count(int idx, int n) {
        if (idx == 5) {
            if (n == 0)
                ++ans;
            return;
        }

        for (int i = 0; i <= n; ++i) {
            count(idx + 1, n - i);
        }
    }
}