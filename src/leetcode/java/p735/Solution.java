package leetcode.java.p735;
// https://leetcode.com/problems/asteroid-collision/

import java.util.Stack;

/**
 * Stack
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; ++i) {
            if (!stack.isEmpty() && stack.peek() < 0)
                stack.push(asteroids[i]);
            else {
                if (asteroids[i] > 0)
                    stack.push(asteroids[i]);
                else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() == -asteroids[i]) {
                        stack.pop();
                    } else if (stack.isEmpty() || stack.peek() * asteroids[i] > 0) {
                        stack.push(asteroids[i]);
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < stack.size(); ++i) {
            ans[i] = stack.get(i);
        }
        return ans;
    }
}