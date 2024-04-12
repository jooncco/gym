package leetcode.java.p42;
// https://leetcode.com/problems/trapping-rain-water/

import java.util.*;

/**
 * Stack
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(height[0]);
        int left = height[0];
        for (int i = 1; i < n; ++i) {
            if (left >= height[i]) {
                stack.push(height[i]);
            } else {
                int minHeight = Math.min(left, height[i]);
                while (!stack.isEmpty()) {
                    water += minHeight - stack.pop();
                }
                stack.push(height[i]);
                left = height[i];
            }
        }
        // Remaining trapped water on the right side
        int right = stack.pop();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            water += Math.max(0, right - cur);
            right = Math.max(right, cur);
        }
        return water;
    }
}