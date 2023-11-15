package leetcode.p1846;
// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/

import java.util.*;

/**
 * Greedy
 * | Time: O(n log(n))
 * | Space: O(1)
 */
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n= arr.length;
        Arrays.sort(arr);
        int ans= 1;
        for (int i=0; i < n; ++i) {
            if (arr[i] >= ans) ++ans;
        }
        return ans-1;
    }
}
