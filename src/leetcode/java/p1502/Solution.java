package leetcode.java.p1502;
// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

import java.util.Arrays;

/**
 * Sorting
 * | Time: O (n log n)
 * | Space: O (1)
 */
public class Solution {
	public boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		int diff = arr[1] - arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] - arr[i - 1] != diff)
				return false;
		}
		return true;
	}
}