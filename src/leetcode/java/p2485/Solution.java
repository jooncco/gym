package leetcode.java.p2485;
// https://leetcode.com/problems/find-the-pivot-integer/

/**
 * Math, Binary Search
 * Time: O(log(n))
 * Space: O(1)
 */
public class Solution {
    public int pivotInteger(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            int leftSum = m * (m + 1) / 2;
            int rightSum = (m + n) * (n - m + 1) / 2;
            if (leftSum >= rightSum) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        int leftSum = l * (l + 1) / 2;
        int rightSum = (l + n) * (n - l + 1) / 2;
        boolean pivotExists = leftSum == rightSum;
        return pivotExists ? l : -1;
    }
}