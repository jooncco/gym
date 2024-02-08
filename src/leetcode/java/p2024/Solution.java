package leetcode.java.p2024;
// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

/**
 * Sliding Window
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
	public int maxConsecutiveAnswers(String answerKey, int k) {
		return Math.max(
				findMaxLength(answerKey, 'T', k),
				findMaxLength(answerKey, 'F', k));
	}

	private int findMaxLength(String answerKey, char target, int k) {
		int ans = 0, l = -1, used = 0;
		for (int i = 0; i < answerKey.length(); ++i) {
			if (answerKey.charAt(i) != target) {
				if (used < k) {
					++used;
				} else {
					while (l < i && answerKey.charAt(l + 1) == target)
						++l;
					++l;
				}
			}
			ans = Math.max(ans, i - l);
		}
		return ans;
	}
}