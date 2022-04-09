package leetcode.p703;
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

    private Queue<Integer> arr;
    private int k;

    public KthLargest(int k, int[] nums) {
        arr= new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        arr.offer(val);
        if (arr.size() > k) {
            arr.poll();
        }
        return arr.peek();
    }
}