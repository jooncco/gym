package leetcode.p703;

import java.util.PriorityQueue;

/**
 * Priority Queue
 * | Time: O (n log n) for constructor, O (log n) for add
 * | Space: O (k)
 */
public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> topK;

    public KthLargest(int k, int[] nums) {
        this.k= k;
        topK= new PriorityQueue<>();
        for (int num : nums) {
            topK.add(num);
            if (topK.size() > k) topK.poll();
        }
    }

    public int add(int val) {
        topK.add(val);
        if (topK.size() > k) topK.poll();
        if (topK.isEmpty()) return -1;
        return topK.peek();
    }
}