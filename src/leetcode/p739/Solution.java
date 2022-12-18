package leetcode.p739;
// https://leetcode.com/problems/daily-temperatures/

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack= new Stack<>();
        int[] ans= new int[temperatures.length];
        for (int i=0; i < temperatures.length-1; ++i) {
            if (temperatures[i] < temperatures[i+1]) {
                ans[i]= 1;
                while (!stack.empty() && stack.peek()[0] < temperatures[i+1]) {
                    int[] top= stack.peek();
                    ans[top[1]]= i+1-top[1];
                    stack.pop();
                }
            }
            else {
                stack.push(new int[]{temperatures[i], i});
            }
        }
        int idx= temperatures.length - 1;
        int temp= temperatures[idx];
        while (!stack.empty()) {
            int[] top= stack.pop();
            if (top[0] < temp) {
                ans[top[1]]= idx - top[1];
            } else {
                idx= top[1];
                temp= top[0];
            }
        }
        return ans;
    }
}