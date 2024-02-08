package leetcode.java.p1470;
// https://leetcode.com/problems/shuffle-the-array/

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            ret[i * 2] = nums[i];
        }
        for (int i = n; i < 2 * n; ++i) {
            ret[(i - n) * 2 + 1] = nums[i];
        }
        return ret;
    }
}