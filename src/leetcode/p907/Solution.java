package leetcode.p907;
// https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Stack;

public class Solution {
    private final int MOD= (int)1e9 + 7;
    private Stack<Integer> stack= new Stack<>();

    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        int[] left= new int[n], right= new int[n];
        for (int i=0; i < n; ++i) {
            left[i]= i+1; right[i]= n-i;
        }
        // "less element" := largest among the values smaller than the value of interest
        for (int i=0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                // distance to the next "less element"
                int x= stack.pop();
                right[x]= i - x;
            }
            // distance to the previous "less element"
            left[i]= stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        long ans= 0;
        for (int i=0; i < n; ++i) ans= (ans + 1L*arr[i]*left[i]*right[i])%MOD;
        return (int)ans;
    }
}