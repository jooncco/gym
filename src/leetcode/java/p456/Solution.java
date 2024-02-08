package leetcode.java.p456;
// https://leetcode.com/problems/132-pattern/

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int secondLarge = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; --i) {
            if (secondLarge > nums[i])
                return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                secondLarge = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}