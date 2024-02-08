package leetcode.java.p1561;
// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

import java.util.*;

/**
 * Greedy, Sortings, Two Pointers
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l = 0, r = piles.length - 1;
        int ans = 0;
        while (l < r) {
            ans += piles[r - 1];
            ++l;
            r -= 2;
        }
        return ans;
    }
}