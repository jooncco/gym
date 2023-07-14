package leetcode.p1218;
// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

import java.util.HashMap;

/**
 * Dynamic Programming
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int longestSubsequence(int[] arr, int D) {
        var map= new HashMap<Integer, Integer>();
		int ans= 1;
		for (int num : arr) {
			int len= map.getOrDefault(num-D, 0) + 1;
			ans= Math.max(ans, len);
			map.put(num, len);
		}
		return ans;
    }
}