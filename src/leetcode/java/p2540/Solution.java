package leetcode.java.p2540;
// https://leetcode.com/problems/minimum-common-value/

/**
 * Two Pointers
 * Time: O(n + m)
 * Space: O(1)
 */
public class Solution {
    public int getCommon(int[] A, int[] B) {
        int l = 0, r = 0;
        for (int i = 0; i < A.length; ++i) {
            while (r < B.length && B[r] < A[i])
                ++r;
            if (r == B.length)
                return -1;
            if (A[i] == B[r])
                return A[i];
        }
        return -1;
    }
}