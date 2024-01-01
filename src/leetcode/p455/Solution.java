package leetcode.p455;

import java.util.*;

/**
 * Greedy
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int ans= 0, j= 0;
        for (int i= 0; i < g.length; ++i) {
            while (j < s.length && s[j] < g[i]) ++j;
            if (j >= s.length) break;
            ++ans;
            ++j;
        }
        return ans;
    }
}