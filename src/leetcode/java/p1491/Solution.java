package leetcode.java.p1491;
// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

/**
 * Math
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
	public double average(int[] salary) {
		double sum = 0;
		int mn = Integer.MAX_VALUE, mx = 0;
		for (int amount : salary) {
			sum += amount;
			mn = Math.min(mn, amount);
			mx = Math.max(mx, amount);
		}
		return (sum - mn - mx) / (salary.length - 2);
	}
}