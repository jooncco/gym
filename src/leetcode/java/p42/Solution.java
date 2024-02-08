package leetcode.java.p42;
// https://leetcode.com/problems/trapping-rain-water/

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer[]> walls = new Stack<>();
        int[] waterLevels = new int[n];
        for (int i = 0; i < n; ++i) {
            if (height[i] > 0) {
                while (!walls.isEmpty() && walls.peek()[0] <= height[i]) {
                    Integer[] wall = walls.pop();
                    for (int j = i - 1; j > wall[1]; --j)
                        waterLevels[j] = wall[0];
                }
                if (!walls.isEmpty() && walls.peek()[0] > height[i]) {
                    Integer[] wall = walls.peek();
                    for (int j = i - 1; j > wall[1]; --j)
                        waterLevels[j] = height[i];
                }
                walls.push(new Integer[] { height[i], i });
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans += Math.max(0, waterLevels[i] - height[i]);
        return ans;
    }
}