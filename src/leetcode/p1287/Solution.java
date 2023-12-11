package leetcode.p1287;
// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

/**
 * DP(Bottom-up)
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public int findSpecialInteger(int[] arr) {
        double cut= arr.length/4.0;
        int cnt= 0, prev= -1;
        for (int num : arr) {
            if (num == prev) ++cnt;
            else cnt= 1;
            if (cut < cnt) return num;
            prev= num;
        }
        return prev;
    }
}