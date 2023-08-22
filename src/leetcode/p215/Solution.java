package leetcode.p215;
// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.*;

/**
 * Sortings, Implementation
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>((int)1e5+7, (a,b) -> a-b);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}