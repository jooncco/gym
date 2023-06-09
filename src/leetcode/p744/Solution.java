package leetcode.p744;
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

/**
 * Ad hoc
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans= letters[0];
		for (char c : letters) {
			if (c > target) {
				ans= c;
				break;
			}
		}
		return ans;
    }
}