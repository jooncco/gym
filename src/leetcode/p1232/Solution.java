package leetcode.p1232;
// https://leetcode.com/problems/check-if-it-is-a-straight-line/

/**
 * Geometry
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
		// infinite or zero gradient ?
	    boolean infinite= true, zero= true;
	    for (int i=1; i < coordinates.length; ++i) {
			if (coordinates[i-1][0] != coordinates[i][0]) infinite= false;
			if (coordinates[i-1][1] != coordinates[i][1]) zero= false;
	    }
		if (infinite || zero) return true;

		int a= coordinates[0][0], b= coordinates[0][1];
		int mNumerator= coordinates[0][1]-coordinates[1][1], mDenominator= coordinates[0][0]-coordinates[1][0];
		for (int i=2; i < coordinates.length; ++i) {
			if ((coordinates[i][1]-b)*mDenominator != mNumerator*(coordinates[i][0]-a)) {
				return false;
			}
		}
		return true;
    }
}